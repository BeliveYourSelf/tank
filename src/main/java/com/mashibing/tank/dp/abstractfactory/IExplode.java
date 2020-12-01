package com.mashibing.tank.dp.abstractfactory;

import com.mashibing.tank.ResourceMgr;
import com.mashibing.tank.TankFrame;

import java.awt.*;

/**
 * Created by Administrator on 2020/11/30 21:43
 */
public interface IExplode {

    public static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT =ResourceMgr.explodes[0].getHeight();
    public int x = 0,y = 0;
    public TankFrame tf = null;
    public int step = 0;

    public void paint(Graphics g);
}
