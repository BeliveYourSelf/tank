package com.mashibing.tank.dp.strategy;/**
 * Created by Administrator on 2020/11/29 20:03
 */

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Tank;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 20:03
 * @Param
 * @return
 **/
public class BadTankFire implements Fire{

    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tank.getTf().getBullets().add(new Bullet(bX,bY,tank.getDir(),tank.getGroup(),tank.getTf()));
    }
}
