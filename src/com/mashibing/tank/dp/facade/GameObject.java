package com.mashibing.tank.dp.facade;/**
 * Created by Administrator on 2020/12/2 22:13
 */

import com.mashibing.tank.Tank;

import java.awt.*;
import java.util.List;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/2 22:13
 * @Param
 * @return
 **/
public interface GameObject {
    public Rectangle getRect();
    public int getSize();
    public void paint(Graphics g);
    public void collideWith(List<GameObject> gameObjects,GameObject gameObject);
    public void die();

}
