package com.mashibing.tank.dp.facade;/**
 * Created by Administrator on 2020/12/2 23:37
 */

import com.mashibing.tank.*;
import com.mashibing.tank.dp.cor.BulletTankCollider;
import com.mashibing.tank.dp.cor.Collider;
import com.mashibing.tank.dp.cor.ColliderChain;
import com.mashibing.tank.dp.cor.TankTankCollider;
import com.mashibing.tank.dp.mediator.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/2 23:37
 * GameModel:即时门面也是调停者
 * 门面：  TF 和 GameModel 打交道
 * 调停者（居委会大妈）：    GameModel  和 内部的各个类打交道（Tank,Bullet,Explode）
 * @Param
 * @return
 **/
public class GameModel {

    Tank myTank = new Tank(200,400, Dir.DOWN, Group.GOOD,this);
//    public java.util.List<Bullet> bullets = new ArrayList<>();
//    public java.util.List<Tank> tanks = new ArrayList<>();
//    public List<Explode> explodes = new ArrayList<>();
//    Collider collider1 = new BulletTankCollider();
//    Collider collider2 = new TankTankCollider();
    ColliderChain colliderChain = new ColliderChain();
    List<GameObject> objects = new ArrayList<>();

    public GameModel(){
        int initTankCount =PropertyMgr.getInteger("initTankCount"); // Object只能 先 String  后 转 Integer
        //初始化地方坦克
        for (int i = 0; i < initTankCount; i++) {
            objects.add(new Tank(50 +i*60,200,Dir.DOWN,Group.BAD,this));
        }
    }

    public void add(GameObject gameObject) {
        this.objects.add(gameObject);
    }
    public void remove(GameObject gameObject) {
        this.objects.remove(gameObject);
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹数量:" + bullets.size(),10,60);
//        g.drawString("坦克数量:" + tanks.size(),10,80);
//        g.drawString("爆炸数量:" + explodes.size(),10,100);
        g.setColor(c);
        myTank.paint(g);   //Tank自己画，比较合适

        for (int i=0;i<objects.size();i++) {
            objects.get(i).paint(g);
        }
        // 互相碰撞--责任链（各个对象的碰撞策略排在一起）
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) { //Comparator.compare(o1.o2)
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1,o2);
            }
        }
//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
