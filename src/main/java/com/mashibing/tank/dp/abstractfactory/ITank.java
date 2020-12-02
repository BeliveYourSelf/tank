package com.mashibing.tank.dp.abstractfactory;

import com.mashibing.tank.*;
import com.mashibing.tank.dp.strategy.DefaultFireStrategy;
import com.mashibing.tank.dp.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * Created by Administrator on 2020/11/30 21:31
 *
 * 接口定义的值属性值为 public final static,当接口被对象赋值后，如果想使用实现类的属性值请用get 方法，  itank.x 直接调用，会调用接口public final static，不是调用实现类的属性值
 */
public interface ITank {
//    public int x=0,y=0;
//    boolean live = true;
    public Dir dir = Dir.DOWN;
    public final int SPEED = PropertyMgr.getInteger("tankSpeed");
    public static int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT =ResourceMgr.goodTankD.getHeight();
//    public boolean moving = true;
//    public Random random =new Random();
//    Rectangle rect = new Rectangle();
//    public Group group = Group.BAD;

    public void paint(Graphics g);
    public void setMoving(boolean moving);
    public void setDir(Dir dir);
    public void move();
    public void boundsCheck();
    public void randomDir();
    public void fire(FireStrategy fireStrategy);
    public void die();
    public int getX();
    public int getY();
    public Group getGroup();
    public boolean isLive();
    public TankFrame getTf();
    public FireStrategy getFs();
    public Rectangle getRect();


}
