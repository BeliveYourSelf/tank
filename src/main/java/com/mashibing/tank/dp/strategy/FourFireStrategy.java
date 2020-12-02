package com.mashibing.tank.dp.strategy;/**
 * Created by Administrator on 2020/11/29 20:33
 */

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Dir;
import com.mashibing.tank.Tank;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 20:33
 * @Param
 * @return
 **/
public class FourFireStrategy implements FireStrategy{

    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            t.tf.gf.createBullet(bX, bY, dir, t.group, t.tf);
            new Bullet(bX,bY,dir,t.group,t.tf);
        }
    }
}
