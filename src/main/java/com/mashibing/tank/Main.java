package com.mashibing.tank;

/**
 * AWT 创建窗口
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
		// TODO Auto-generated method stub
		TankFrame tf = new TankFrame();


//		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		while(true) {			// 让黑块自动移动
			Thread.sleep(50);
			tf.repaint();
		}
	}

}
