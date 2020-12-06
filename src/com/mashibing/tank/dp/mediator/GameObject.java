package com.mashibing.tank.dp.mediator;/**
 * Created by Administrator on 2020/12/3 22:09
 */

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/3 22:09
 * @Param
 * @return
 **/
public abstract class GameObject {
    public int x,y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();

}
