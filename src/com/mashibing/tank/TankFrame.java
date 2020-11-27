package com.mashibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

	Tank myTank = new Tank(200,200,Dir.DOWN);

	public TankFrame() {

		setSize(800, 600);
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

	// 系统自动调用：当窗口需要重新绘制（打开窗口，移动窗口，关闭窗口。。。）
	@Override
	public void paint(Graphics g) {

		myTank.paint(g);   //Tank自己画，比较合适

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
