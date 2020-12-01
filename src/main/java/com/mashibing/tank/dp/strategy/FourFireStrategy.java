package com.mashibing.tank.dp.strategy;/**
 * Created by Administrator on 2020/11/29 20:33
 */

import com.mashibing.tank.Dir;
import com.mashibing.tank.dp.abstractfactory.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 20:33
 * @Param
 * @return
 **/
public class FourFireStrategy implements FireStrategy{

    public void fire(ITank t) {
        GoodTank goodTank = (GoodTank)t;
        int bX = goodTank.x + ITank.WIDTH/2 - IBullet.WIDTH/2;
        int bY = goodTank.y + ITank.HEIGHT/2 - IBullet.HEIGHT/2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new GoodTankFactory().createBullet(bX,bY,dir,goodTank.group,goodTank.tf);
        }
    }
}
