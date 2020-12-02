package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/27 13:40
 */

import com.mashibing.tank.*;
import com.mashibing.tank.dp.strategy.DefaultFireStrategy;
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
public class BadTank implements ITank{
    public int x,y;
    private boolean live = true;
    public Dir dir = Dir.DOWN;
    private final int SPEED = PropertyMgr.getInteger("tankSpeed");
    public static int WIDTH =ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT =ResourceMgr.goodTankD.getHeight();
    public TankFrame tf;
    private boolean moving = true;
    private Random random =new Random();
    public Group group = Group.BAD;
    FireStrategy fs;
    Rectangle rect = new Rectangle();


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

    public BadTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = Group.BAD;
        this.tf = tf;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.WIDTH;
        rect.height = this.HEIGHT;
        String badFsName = PropertyMgr.getString("badFs");
        try {
//            fs = (FireStrategy) Class.forName(badFsName).getDeclaredConstructor().newInstance(); // 可以指定构造方法
             fs = new DefaultFireStrategy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        if(!live) tf.tanks.remove(this);
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.badTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.badTankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.badTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.badTankD,x,y,null);
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

    public void move() {
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

        if (random.nextInt(100) > 95)
            fire(this.fs);
        if(random.nextInt(100) > 95)
            randomDir();

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    public void boundsCheck() {
        if(this.x < 2) x = 2;
        if(this.y < 28) y = 28;
        if(this.x > TankFrame.GAME_WIDTH - BadTank.WIDTH -2) x = TankFrame.GAME_WIDTH - BadTank.WIDTH -2;
        if(this.y > TankFrame.GAME_HEIGHT - BadTank.HEIGHT -2) y = TankFrame.GAME_HEIGHT - BadTank.HEIGHT - 2;

    }

    @Override
    public boolean isLive() {
        return live;
    }

    @Override
    public TankFrame getTf() {
        return tf;
    }

    @Override
    public FireStrategy getFs() {
        return fs;
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }

    public void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(FireStrategy fireStrategy) {
        fireStrategy.fire(this);
    }

    public void die() {
        live = false;
    }
}