package com.mashibing.tank.dp.cor;/**
 * Created by Administrator on 2020/12/3 22:33
 */

import com.mashibing.tank.Tank;
import com.mashibing.tank.dp.mediator.GameObject;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/3 22:33
 * @Param
 * @return
 **/
public class TankTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                //                t1.stop();
                //                t2.stop();
                t1.back();
                t2.back();
                return false;
            }
        }
        return true;
    }
}
