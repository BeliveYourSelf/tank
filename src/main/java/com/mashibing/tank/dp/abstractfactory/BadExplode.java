package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/27 14:33
 */

import com.mashibing.tank.Audio;
import com.mashibing.tank.ResourceMgr;
import com.mashibing.tank.TankFrame;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 14:33
 * @Param
 * @return
 **/
public class BadExplode implements IExplode{

    private static final int SPEED = 10;
    public static int WIDTH =ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT =ResourceMgr.explodes[0].getHeight();
    private int x,y;
    private TankFrame tf;
    private int step = 0;




    public BadExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(new Runnable() {
            public void run() {
                new Audio("audio/explode.wav").play();
            }
        }).start();
    }
    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);

        if (step >= ResourceMgr.explodes.length)  {
            step = 0;
            tf.explodes.remove(this);}
    }





}
