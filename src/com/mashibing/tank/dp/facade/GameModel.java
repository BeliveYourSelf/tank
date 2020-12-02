package com.mashibing.tank.dp.facade;/**
 * Created by Administrator on 2020/12/2 23:37
 */

import com.mashibing.tank.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/2 23:37
 * @Param
 * @return
 **/
public class GameModel {

    Tank myTank = new Tank(200,400, Dir.DOWN, Group.GOOD,this);

    public java.util.List<Bullet> bullets = new ArrayList<>();
    public java.util.List<Tank> tanks = new ArrayList<>();
    public List<Explode> explodes = new ArrayList<>();
    public GameModel(){
        int initTankCount =PropertyMgr.getInteger("initTankCount"); // Object只能 先 String  后 转 Integer
        //初始化地方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 +i*60,200,Dir.DOWN,Group.BAD,this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量:" + bullets.size(),10,60);
        g.drawString("坦克数量:" + tanks.size(),10,80);
        g.drawString("爆炸数量:" + explodes.size(),10,100);
        g.setColor(c);
        myTank.paint(g);   //Tank自己画，比较合适

        for (int i=0;i<bullets.size();i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i <tanks.size() ; i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i <explodes.size() ; i++) {
            explodes.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
