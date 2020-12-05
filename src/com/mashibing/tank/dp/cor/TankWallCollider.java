package com.mashibing.tank.dp.cor;/**
 * Created by Administrator on 2020/12/5 11:30
 */

import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;
import com.mashibing.tank.dp.mediator.GameObject;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/5 11:30
 * @Param
 * @return
 **/
public class TankWallCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall && ((Tank) o1).getRect().intersects(((Wall) o2).rect)){
            ((Tank) o1).preLocation();
            return true;
        } else if(o2 instanceof Tank && o1 instanceof Wall && ((Tank) o2).getRect().intersects(((Wall) o1).rect)){
            ((Tank) o2).preLocation();
            return true;
        }
        return false;
    }


}
