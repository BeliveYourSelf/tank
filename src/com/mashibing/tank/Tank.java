package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/27 13:40
 */

import java.awt.*; /**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 13:40
 * @Param
 * @return
 **/
public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;
    private final int SPEED = 5;
    private TankFrame tf;


    private boolean moving = false;

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
        }

        move();
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void move() {
        if(!moving) return;

        switch(dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(x,y,dir,tf));
    }
}
