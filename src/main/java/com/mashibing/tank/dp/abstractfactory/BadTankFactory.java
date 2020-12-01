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
public class BadTankFactory extends AbstractTankFactory{

    public ITank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new BadTank(x,y,dir,group,tf);
    }

    public IBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new BadBullet(x,y,dir,group,tf);
    }

    IExplode createExplode(int x, int y, TankFrame tf) {
        return new BadExplode(x,y,tf);
    }
}
