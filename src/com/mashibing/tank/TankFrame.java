package com.mashibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

	int x =200 , y=200;
	
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
		System.out.println("paint");
		g.fillRect(x, y, 50, 50);
		
		x += 10;
	}
	
	
	class MyKeyListener extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed");
			x +=200;
			repaint();       //重新触发paint方法
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
		}
		
	}
}
