package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/27 14:33
 */

import com.mashibing.tank.dp.facade.GameObject;

import java.awt.*;
import java.util.List;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 14:33
 * @Param
 * @return
 **/
public class Explode implements GameObject {

    private static final int SPEED = 10;
    public static int WIDTH =ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT =ResourceMgr.explodes[0].getHeight();
    private int x,y;
    private TankFrame tf;
    private int step = 0;

    Rectangle rect = new Rectangle();


    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.WIDTH;
        rect.height = this.HEIGHT;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }
    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);

        if (step >= ResourceMgr.explodes.length)  {
            step = 0;
            tf.getGameObjects().remove(this);}
    }

    @Override
    public void collideWith(List<GameObject> gameObjects, GameObject gameObject) {
        return;
    }

    @Override
    public void die() {
        return;
    }


    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
