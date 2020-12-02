package com.mashibing.tank.dp.strategy;/**
 * Created by Administrator on 2020/11/29 20:33
 */

import com.mashibing.tank.dp.abstractfactory.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 20:33
 * @Param
 * @return
 **/
public class DefaultFireStrategy implements FireStrategy{

    public void fire(ITank t) {
        BadTank badTank = (BadTank) t;
        int bX = badTank.x + ITank.WIDTH/2 - IBullet.WIDTH/2;
        int bY = badTank.y + ITank.HEIGHT/2 - IBullet.HEIGHT/2;
        new BadTankFactory().createBullet(bX,bY,badTank.getDir(),badTank.group,badTank.tf);
    }
}
