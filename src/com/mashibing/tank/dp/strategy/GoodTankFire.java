package com.mashibing.tank.dp.strategy;/**
 * Created by Administrator on 2020/11/29 19:44
 */

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Dir;
import com.mashibing.tank.Tank;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 19:44
 * @Param
 * @return
 **/
public class GoodTankFire implements Fire{

    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tank.getTf().getBullets().add(new Bullet(bX,bY, Dir.UP,tank.getGroup(),tank.getTf()));
        tank.getTf().getBullets().add(new Bullet(bX,bY,Dir.DOWN,tank.getGroup(),tank.getTf()));
        tank.getTf().getBullets().add(new Bullet(bX,bY,Dir.LEFT,tank.getGroup(),tank.getTf()));
        tank.getTf().getBullets().add(new Bullet(bX,bY,Dir.RIGHT,tank.getGroup(),tank.getTf()));
    }
}
