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
		
		x += 10;
	}
	
	
	class MyKeyListener extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed");
			x +=200;
			repaint();       //���´���paint����
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
		}
		
	}
}
