package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/12/1 23:58
 */

import com.mashibing.tank.Tank;

import java.awt.*; /**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/1 23:58
 * @Param
 * @return
 **/
public abstract class BaseBullet {

    public abstract void collideWith(BaseTank tank);

    public abstract void paint(Graphics g);
}
