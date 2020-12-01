package com.mashibing.tank.dp.abstractfactory;

import com.mashibing.tank.*;

import java.awt.*;

/**
 * Created by Administrator on 2020/11/30 21:40
 */
public interface IBullet<T> {
    public static final int SPEED = PropertyMgr.getInteger("bulletSpeed");
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT =ResourceMgr.bulletD.getHeight();
    public int x = 0,y = 0;
    public Dir dir = null;
    public TankFrame tf = null;
    public boolean living = true;
    public Group group = Group.BAD;
    Rectangle rect = new Rectangle();


    public void paint(Graphics g);

    public void move();

    public void collideWith(T iTank);

    public void die();

}
