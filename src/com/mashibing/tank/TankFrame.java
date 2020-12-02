package com.mashibing.tank;

import com.mashibing.tank.dp.facade.GameObject;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public interface TankFrame {

	public List<GameObject> getGameObjects();
	public List<GameObject> addGameObjects(GameObject gameObject);
	public void collideWith(List<GameObject> gameObjects,GameObject gameObject);

	static final int GAME_WIDTH =PropertyMgr.getInteger("gameWidth"), GAME_HEIGHT=PropertyMgr.getInteger("gameHeight");;


	// 系统自动调用：当窗口需要重新绘制（打开窗口，移动窗口，关闭窗口。。。）
	public void paint(Graphics g);

}
