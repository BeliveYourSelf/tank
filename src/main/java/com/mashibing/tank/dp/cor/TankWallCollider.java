package com.mashibing.tank.dp.cor;/**
 * Created by Administrator on 2020/12/3 22:33
 */

import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;
import com.mashibing.tank.dp.mediator.GameObject;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/3 22:33
 * @Param
 * @return
 **/
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t1 = (Tank) o1;
            Wall wall = (Wall) o2;
            if (t1.getRect().intersects(wall.rect)) {
                //                t1.stop();
                //                t2.stop();
                t1.back();
                return false;
            }
        } else if(o1 instanceof Wall && o2 instanceof Tank){
            collide(o2,o1);
        }

        return true;
    }
}
