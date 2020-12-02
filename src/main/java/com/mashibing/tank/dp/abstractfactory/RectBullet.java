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
public class RectBullet extends BaseBullet {

    private static final int SPEED = PropertyMgr.getInteger("bulletSpeed");
    public static int WIDTH =ResourceMgr.bulletD.getWidth();
    public static int HEIGHT =ResourceMgr.bulletD.getHeight();
    private int x,y;
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

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
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
    public void paint(Graphics g){
        if (!living) {
            tf.bullets.remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 20, 20);
        g.setColor(c);
        move();
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

    public void collideWith(BaseTank tank) {
        if(this.group == tank.getGroup()) return;

        // TODO ： 用一个 rect 来记录子弹位置
        if (this.rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tf.explodes.add(tf.gf.createExplode(eX,eY,tf));
        }
    }

    private void die() {
        living = false;
    }
}
