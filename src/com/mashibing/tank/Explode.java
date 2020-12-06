package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/27 14:33
 */

import com.mashibing.tank.dp.facade.GameModel;
import com.mashibing.tank.dp.mediator.GameObject;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 14:33
 * @Param
 * @return
 **/
public class Explode extends GameObject {

    private static final int SPEED = 10;
    public static int WIDTH =ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT =ResourceMgr.explodes[0].getHeight();
    private int step = 0;




    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
        GameModel.getInstance().add(this);
    }
    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);

        if (step >= ResourceMgr.explodes.length)  {
            step = 0;
            GameModel.getInstance().remove(this);
        }
    }


    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }


}
