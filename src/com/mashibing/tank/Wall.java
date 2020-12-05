package com.mashibing.tank;/**
 * Created by Administrator on 2020/12/5 11:01
 */

import com.mashibing.tank.dp.facade.GameModel;
import com.mashibing.tank.dp.mediator.GameObject;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/5 11:01
 * @Param
 * @return
 **/
public class Wall extends GameObject {
    private int x,y;
    public static int WIDTH =ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT =ResourceMgr.goodTankD.getHeight();
    public Rectangle rect = new Rectangle();
    public Wall(GameModel gameModel){
        x = 80;
        y = 80;
        rect.setSize(x+(WIDTH/2),y+(HEIGHT/2));
        gameModel.add(this);
    }
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(x,y,WIDTH,HEIGHT);
        g.setColor(color);
    }

}
