package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/12/2 0:07
 */

import com.mashibing.tank.Audio;
import com.mashibing.tank.ResourceMgr;
import com.mashibing.tank.TankFrame;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/2 0:07
 * @Param
 * @return
 **/
public class RectExplode extends BaseExplode{

    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT =ResourceMgr.explodes[0].getHeight();
    private int x,y;
    private TankFrame tf;
    private int step = 0;




    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){

//        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10 * step ,10 *step);
        step++;
        if (step >= 5)  {
            tf.explodes.remove(this);}
            g.setColor(c);
    }
}
