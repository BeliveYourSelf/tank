package com.mashibing.tank;

/**
 * AWT 创建窗口
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TankFrame tf = new TankFrame();
		//初始化地方坦克
		for (int i = 0; i < 5; i++) {
			tf.tanks.add(new Tank(50 +i*60,200,Dir.DOWN,Group.BAD,tf));
		}
		while(true) {			// 让黑块自动移动
			Thread.sleep(50);
			tf.repaint();
		}
	}

}
