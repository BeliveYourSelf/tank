package com.mashibing.tank.dp.decorator;/**
 * Created by Administrator on 2020/12/6 17:06
 */

import com.mashibing.tank.dp.mediator.GameObject;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/6 17:06
 * @Param
 * @return
 **/
public class RecDecorator extends GODecorator {

    public RecDecorator(GameObject go) {
        super(go);
    }
    @Override
    public void paint(Graphics g) {
        this.x =go.x;
        this.y =go.y;
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.drawRect(super.go.x,super.go.y,super.go.getWidth(),super.go.getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();

    }
}
