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
    private final int SPEED = 1;
    public static int WIDTH =ResourceMgr.tankD.getWidth();
    public static int HEIGHT =ResourceMgr.tankD.getHeight();
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
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }

        move();
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

        System.out.println(this.group.name());
        System.out.println(Group.BAD == this.group);
        System.out.println(Group.BAD.name());
        if (random.nextInt(10)>8 && this.group.equals(Group.BAD)){
            fire();
            randomDirection();
        }


    }

    private void randomDirection() {
                int i = random.nextInt(3);
                switch (i){
                    case 0: this.dir = Dir.DOWN;
                        break;
                    case 1: this.dir = Dir.UP;
                        break;
                    case 2: this.dir = Dir.LEFT;
                        break;
                    case 3: this.dir = Dir.RIGHT;
                        break;
                        default: break;
                }
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bX,bY,dir,this.group,tf));
    }

    public void die(Graphics g) {
        Tank tank= this;
        live = false;
        Explode explode = new Explode(tank.x, tank.y, tf);
        tf.explodes.add(explode);
    }
}
