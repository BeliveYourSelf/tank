package com.mashibing.tank;

import com.mashibing.tank.dp.facade.GameModel;
import com.mashibing.tank.dp.strategy.FourFireStrategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame{


	static final int GAME_WIDTH =PropertyMgr.getInteger("gameWidth"), GAME_HEIGHT=PropertyMgr.getInteger("gameHeight");;


	public TankFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);  // 固定窗口大小
		setTitle("tank war"); // 设置标题栏名称
		setVisible(true);     //

		this.addKeyListener(new MyKeyListener());
		// 设置可以关闭窗体
		addWindowListener(new WindowAdapter() {    // WindowAdapter  继承 WindowListner
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

    // TODO 解决屏幕闪动-双缓冲问题(加完之后，坦克和子弹变型)
    Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	// 系统自动调用：当窗口需要重新绘制（打开窗口，移动窗口，关闭窗口。。。）
	@Override
	public void paint(Graphics g) {
		GameModel.getInstance().paint(g);
	}


	class MyKeyListener extends KeyAdapter{

		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode(); // 获取 键 的代码
			switch(key) {
				case KeyEvent.VK_LEFT:
					bL = true;
					break;
				case KeyEvent.VK_UP:
					bU = true;
					break;
				case KeyEvent.VK_RIGHT:
					bR = true;
					break;
				case KeyEvent.VK_DOWN:
					bD = true;
					break;
			}
			setMainTankDir();
			System.out.println("keyPressed");
			repaint();       //重新触发paint方法
		}


		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");

			int key = e.getKeyCode(); // 获取 键 的代码
			switch(key) {
				case KeyEvent.VK_LEFT:
					bL = false;
					break;

				case KeyEvent.VK_UP:
					bU = false;
					break;

				case KeyEvent.VK_RIGHT:
					bR = false;
					break;

				case KeyEvent.VK_DOWN:
					bD = false;
					break;

                case KeyEvent.VK_CONTROL:
//                    GameModel.getInstance().getMainTank().fire(new FourFireStrategy());
					GameModel.getInstance().getMainTank().handleFireKey();
                    break;
			}
			setMainTankDir();
		}

		public void setMainTankDir() {
			Tank myTank = GameModel.getInstance().getMainTank();
			if(!bL && !bU && !bD && !bR) myTank.setMoving(false);
			else {
				myTank.setMoving(true);
			}
			if(bL) myTank.setDir(Dir.LEFT);
			if(bU) myTank.setDir(Dir.UP);
			if(bD) myTank.setDir(Dir.DOWN);
			if(bR) myTank.setDir(Dir.RIGHT);

		}

	}


}
