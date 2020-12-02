package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/12/1 23:51
 */

import com.mashibing.tank.*;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/1 23:51
 * @Param
 * @return
 **/
public class DefaultFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x, y, dir, group, tf);
    }

    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }

    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Bullet(x,y,dir,group,tankFrame);
    }
}
