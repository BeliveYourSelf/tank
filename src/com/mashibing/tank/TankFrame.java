package com.mashibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

	int x =200 , y=200;
	
	Dir dir = Dir.DOWN;
	
	private final int SPEED = 10;
	
	public TankFrame() {
		
		setSize(800, 600);
		setResizable(false);  // �̶����ڴ�С
		setTitle("tank war"); // ���ñ���������
		setVisible(true);     // 
		
		this.addKeyListener(new MyKeyListener());
		// ���ÿ��Թرմ���
		addWindowListener(new WindowAdapter() {    // WindowAdapter  �̳� WindowListner
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	// ϵͳ�Զ����ã���������Ҫ���»��ƣ��򿪴��ڣ��ƶ����ڣ��رմ��ڡ�������
	@Override 
	public void paint(Graphics g) {
		System.out.println("paint");
		g.fillRect(x, y, 50, 50);
		
		switch(dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
			
			
		}
	}
	
	
	class MyKeyListener extends KeyAdapter{
		
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		
		
		
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode(); // ��ȡ �� �Ĵ���
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
			
		
			repaint();       //���´���paint����
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
			
			setMainTankDir();
		}
		
		public void setMainTankDir() {
			// TODO Auto-generated method stub
			if(bL) dir = Dir.LEFT;
			if(bU) dir = Dir.UP;
			if(bD) dir = Dir.DOWN;
			if(bR) dir = Dir.RIGHT;
			
		}
		
	}


	
}
