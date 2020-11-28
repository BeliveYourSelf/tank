package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/27 14:33
 */

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 14:33
 * @Param
 * @return
 **/
public class Explode {

    private static final int SPEED = 10;
    public static int WIDTH =ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT =ResourceMgr.explodes[0].getHeight();
    private int x,y;
    private TankFrame tf;
    private boolean living = true;
    private int step = 0;




    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }
    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);

        if (step >= ResourceMgr.explodes.length)
            step = 0;
    }





}
