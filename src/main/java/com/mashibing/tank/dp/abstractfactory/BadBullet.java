package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/27 14:33
 */

import com.mashibing.tank.*;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 14:33
 * @Param
 * @return
 **/
public class BadBullet implements IBullet<ITank> {

    private static final int SPEED = PropertyMgr.getInteger("bulletSpeed");
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;
    private TankFrame tf;
    private boolean living = true;
    private Group group = Group.BAD;

    Rectangle rect = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public BadBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.WIDTH;
        rect.height = this.HEIGHT;
        tf.bullets.add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

        move();
    }

    public void move() {
        switch (dir) {
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }


    @Override
    public void collideWith(ITank tank) {
        if (tank.getGroup() == Group.BAD) return;

            // TODO ： 用一个 rect 来记录子弹位置
            if (this.rect.intersects(tank.getRect())) {
                tank.die();
                this.die();
                int eX = tank.getX() + ITank.WIDTH / 2 - IExplode.WIDTH / 2;
                int eY = tank.getY() + ITank.HEIGHT / 2 - IExplode.HEIGHT / 2;
                tf.explodes.add(new BadTankFactory().createExplode(eX, eY, tf));
            }
        }




    public void die() {
        living = false;
    }
}
