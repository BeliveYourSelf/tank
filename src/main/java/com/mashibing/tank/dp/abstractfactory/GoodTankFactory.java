package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/30 21:30
 */

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/30 21:30
 * @Param
 * @return
 **/
public class GoodTankFactory extends AbstractTankFactory {

    @Override
    public ITank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new GoodTank(x,y,dir,group,tf);
    }
    @Override
    public IBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new GoodBullet(x,y,dir,group,tf);
    }
    @Override
    public IExplode createExplode(int x, int y, TankFrame tf) {
        return new GoodExplode(x,y,tf);
    }
}
