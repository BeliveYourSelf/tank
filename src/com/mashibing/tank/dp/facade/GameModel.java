package com.mashibing.tank.dp.facade;

import com.mashibing.tank.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class GameModel extends Frame implements TankFrame{

	Tank myTank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);

	List<GameObject> gameObjects = new ArrayList<GameObject>();


	static final int GAME_WIDTH =PropertyMgr.getInteger("gameWidth"), GAME_HEIGHT=PropertyMgr.getInteger("gameHeight");;


	public GameModel() {
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

	@Override
	public List<GameObject> getGameObjects() {
		return this.gameObjects;
	}

	@Override
	public List<GameObject> addGameObjects(GameObject gameObject) {
		gameObjects.add(gameObject);
		return gameObjects;
	}

	@Override
	public void collideWith(List<GameObject> gameObjects,GameObject gameObject) {
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObject.getRect().intersects(gameObjects.get(i).getRect()));
			gameObject.die();
			gameObjects.get(i).die();
			gameObjects.remove(i);

		}
	}

	public void collideWith(List<GameObject> gameObjects) {
		for (int i = 0; i < gameObjects.size(); i++) {
			for (int j = 0; j < gameObjects.size(); j++) {
				if (gameObjects.get(i).getRect().intersects(gameObjects.get(j).getRect())) {
					gameObjects.get(i).die();
					gameObjects.get(j).die();
					gameObjects.remove(i);
					gameObjects.remove(j);
				}
			}
		}
	}




	// 系统自动调用：当窗口需要重新绘制（打开窗口，移动窗口，关闭窗口。。。）
	@Override
	public void paint(Graphics g) {

		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹数量:" + gameObjects.size(),10,60);
		g.drawString("坦克数量:" + gameObjects.size(),10,80);
		g.drawString("爆炸数量:" + gameObjects.size(),10,100);
		g.setColor(c);
		myTank.paint(g);   //Tank自己画，比较合适

        for (int i=0;i<gameObjects.size();i++) {
			gameObjects.get(i).paint(g);
        }
		for (int i = 0; i <gameObjects.size() ; i++) {
			gameObjects.get(i).paint(g);
		}

		for (int i = 0; i <gameObjects.size() ; i++) {
			gameObjects.get(i).paint(g);
		}

		collideWith(gameObjects);
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
                    myTank.fire(myTank.fs);
                    break;
			}
			setMainTankDir();
		}

		public void setMainTankDir() {

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
