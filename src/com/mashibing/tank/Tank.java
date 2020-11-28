package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/27 13:40
 */

import java.awt.*;
import java.util.Random;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 13:40
 * @Param
 * @return
 **/
public class Tank {
    private int x,y;
    private boolean live = true;
    private Dir dir = Dir.DOWN;
    private final int SPEED = 5;
    public static int WIDTH =ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT =ResourceMgr.goodTankD.getHeight();
    private TankFrame tf;
    private boolean moving = true;
    private Random random =new Random();
    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if(!live) tf.tanks.remove(this);
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
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

        if (this.group == Group.BAD && random.nextInt(100) > 95)
            fire();
        if(this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bX,bY,dir,this.group,tf));
    }

    public void die() {
        live = false;
    }
}
