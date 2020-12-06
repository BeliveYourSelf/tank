package com.mashibing.tank.dp.decorator;/**
 * Created by Administrator on 2020/12/6 17:05
 */

import com.mashibing.tank.dp.mediator.GameObject;

import java.awt.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/6 17:05
 * @Param
 * @return
 **/
public abstract class GODecorator extends GameObject{

    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);

}
