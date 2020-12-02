package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/27 13:40
 */

import com.mashibing.tank.*;
import com.mashibing.tank.dp.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 13:40
 * @Param
 * @return
 **/
public class RectTank extends BaseTank{
    public int x,y;
    public boolean live = true;
    public Dir dir = Dir.DOWN;
    public final int SPEED = PropertyMgr.getInteger("tankSpeed");
    public static int WIDTH =ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT =ResourceMgr.goodTankD.getHeight();
    public TankFrame tf;
    public boolean moving = true;
    public Random random =new Random();
    public Group group = Group.BAD;
    public FireStrategy fs;
    public Rectangle rect = new Rectangle();


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

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.WIDTH;
        rect.height = this.HEIGHT;
        try {
            if (group == Group.GOOD) {
                String goodFsName = PropertyMgr.getString("goodFs");
                fs = (FireStrategy) Class.forName(goodFsName).getDeclaredConstructor().newInstance(); // 可以指定构造方法
                }
             else{
                String badFs = PropertyMgr.getString("badFs");
                fs = (FireStrategy) Class.forName(badFs).getDeclaredConstructor().newInstance(); // 可以指定构造方法
//                fs = new DefaultFireStrategy();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        if(!live) tf.tanks.remove(this);

        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.BLUE);
        g.fillRect(x, y, 40, 40);
        g.setColor(c);
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

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if(this.x < 2) x = 2;
        if(this.y < 28) y = 28;
        if(this.x > TankFrame.GAME_WIDTH - RectTank.WIDTH -2) x = TankFrame.GAME_WIDTH - RectTank.WIDTH -2;
        if(this.y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT -2) y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2;

    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {

        int bX = this.x + RectTank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + RectTank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bX,bY,this.dir,this.group,this.tf);

    }

    public void die() {
        live = false;
    }
}
