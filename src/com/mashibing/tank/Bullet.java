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
public class Bullet extends GameObject {

    private static final int SPEED = PropertyMgr.getInteger("bulletSpeed");
    public static int WIDTH =ResourceMgr.bulletD.getWidth();
    public static int HEIGHT =ResourceMgr.bulletD.getHeight();

    private Dir dir;
    private boolean living = true;
    private Group group = Group.BAD;

    public Rectangle rect = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.WIDTH;
        rect.height = this.HEIGHT;
        GameModel.getInstance().add(this);
    }
    public void paint(Graphics g){
        if (!living) {
            GameModel.getInstance().remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

        move();
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void move() {
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
        rect.x = this.x;
        rect.y = this.y;
        if(x <0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) living = false;
    }



    public void die() {
        living = false;
    }
}
