package com.mashibing.tank;

import com.mashibing.tank.dp.abstractfactory.BadTankFactory;

/**
 * AWT 创建窗口
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
		// TODO Auto-generated method stub
		TankFrame tf = new TankFrame();

		int initTankCount =PropertyMgr.getInteger("initTankCount"); // Object只能 先 String  后 转 Integer
		//初始化地方坦克
		for (int i = 0; i < initTankCount; i++) {
//			tf.tanks.add(new Tank(50 +i*60,200,Dir.DOWN,Group.BAD,tf));
			tf.tanks.add(new BadTankFactory().createTank(50 +i*60,200,Dir.DOWN,Group.BAD,tf));
		}
//		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		while(true) {			// 让黑块自动移动
			Thread.sleep(50);
			tf.repaint();
		}
	}

}
