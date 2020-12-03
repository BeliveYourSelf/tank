package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/27 13:40
 */

import com.mashibing.tank.dp.facade.GameModel;
import com.mashibing.tank.dp.mediator.GameObject;
import com.mashibing.tank.dp.strategy.DefaultFireStrategy;
import com.mashibing.tank.dp.strategy.FireStrategy;
import com.mashibing.tank.dp.strategy.FourFireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 13:40
 * @Param
 * @return
 **/
public class Tank extends GameObject{
    public int x,y;
    private boolean live = true;
    public Dir dir = Dir.DOWN;
    private final int SPEED = PropertyMgr.getInteger("tankSpeed");
    public static int WIDTH =ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT =ResourceMgr.goodTankD.getHeight();
    private boolean moving = true;
    private Random random =new Random();
    public Group group = Group.BAD;
    FireStrategy fs;
    public int oldX,oldY;
    Rectangle rect = new Rectangle();
    public GameModel gm;

    public Rectangle getRect() {
        return rect;
    }

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

    public Tank(int x, int y, Dir dir,Group group,GameModel gameModel) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = this.WIDTH;
        rect.height = this.HEIGHT;
        gm = gameModel;
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
        if(!live) gm.remove(this);
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
        oldX = x;
        oldY = y;
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
            fire(this.fs);
        if(this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if(this.x < 2) x = 2;
        if(this.y < 28) y = 28;
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH -2) x = TankFrame.GAME_WIDTH - Tank.WIDTH -2;
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;

    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(FireStrategy fireStrategy) {
        fireStrategy.fire(this);
    }

    public void die() {
        live = false;
    }

    public void stop() {
        moving = false;
    }
    //  回到碰撞的上一次位置

    public void preLocation(){
        x = oldX;
        y = oldY;
    }
}
