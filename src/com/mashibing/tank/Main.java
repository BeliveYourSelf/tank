package com.mashibing.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * AWT 创建窗口
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TankFrame tf = new TankFrame();
		
		while(true) {			// 让黑块自动移动
			Thread.sleep(50);
			tf.repaint();
		}
	}

}
