package com.mashibing.tank;

import com.mashibing.tank.dp.facade.GameModel;
import com.mashibing.tank.dp.facade.GameObject;

/**
 * AWT 创建窗口
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
		// TODO Auto-generated method stub
		TankFrame tf = new GameModel();

		int initTankCount =PropertyMgr.getInteger("initTankCount"); // Object只能 先 String  后 转 Integer
		//初始化地方坦克
		for (int i = 0; i < initTankCount; i++) {
			tf.getGameObjects().add(new Tank(50 +i*60,200,Dir.DOWN,Group.BAD,tf));
		}
//		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		while(true) {			// 让黑块自动移动
			Thread.sleep(50);
			GameModel tf1 = (GameModel) tf;
			tf1.repaint();
		}
	}

}
