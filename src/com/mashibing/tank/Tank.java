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
    private final int SPEED = 10;

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);

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
}
