package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/12/1 23:58
 */

import com.mashibing.tank.Group;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/1 23:58
 * @Param
 * @return
 **/
public abstract class BaseTank {

    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();


    public abstract void paint(Graphics graphics);
    public Group getGroup(){
        return this.group;
    }

    public abstract void die();
    public abstract int getX();
    public abstract int getY();
}
