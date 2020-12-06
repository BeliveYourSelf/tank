package com.mashibing.tank;/**
 * Created by Administrator on 2020/12/5 15:50
 */

import com.mashibing.tank.dp.mediator.GameObject;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/5 15:50
 * @Param
 * @return
 **/
public class Wall extends GameObject {
    int x,y,w,h;
    public Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.rect = new Rectangle(x, y, w, h);
    }
    @Override
    public void paint(Graphics g) {
        Color c =g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }
}
