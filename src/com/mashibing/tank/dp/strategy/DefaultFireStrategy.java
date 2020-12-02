package com.mashibing.tank.dp.strategy;/**
 * Created by Administrator on 2020/11/29 20:33
 */

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Tank;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 20:33
 * @Param
 * @return
 **/
public class DefaultFireStrategy implements FireStrategy{

    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bX,bY,t.dir,t.group,t.gm);
    }
}
