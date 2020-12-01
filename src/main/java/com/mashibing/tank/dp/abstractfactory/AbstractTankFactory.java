package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/30 21:28
 */

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/30 21:28
 * @Param
 * @return
 **/
public abstract class AbstractTankFactory {
    abstract ITank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    abstract IBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
    abstract IExplode createExplode(int x, int y, TankFrame tf);


}
