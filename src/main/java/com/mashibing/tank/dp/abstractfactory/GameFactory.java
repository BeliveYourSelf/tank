package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/12/1 23:47
 */

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/1 23:47
 * @Param
 * @return
 **/
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame);
}
