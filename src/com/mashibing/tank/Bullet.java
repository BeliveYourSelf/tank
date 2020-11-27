package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/27 14:33
 */

import java.awt.*;
import java.util.List;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/27 14:33
 * @Param
 * @return
 **/
public class Bullet {

    private static final int SPEED = 10;
    private static int WIDTH =30,HEIGHT =30;
    private int x,y;
    private Dir dir;
    private TankFrame tf;

    private boolean live = true;

    public Bullet(int x, int y,Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g){
        if (!live) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
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
        if(x <0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) live = false;
        if(tf.tanks.size()>0){
            List<Tank> tanks = tf.tanks;
            for(int i=0;i<tanks.size();i++){
                Tank tank = tanks.get(i);
                int tankX = tank.getX();
                int tankY = tank.getY();
                int blx = this.x - WIDTH;
                int brx = this.x + WIDTH;
                int buy = this.y - HEIGHT;
                int bdy = this.y + HEIGHT;
                if( blx < tankX && tankX < brx   && buy < tankY  &&  tankY < bdy ) {
                    this.live = false;
                    tank.setLive(false);
                }
            }
        }
    }
}
