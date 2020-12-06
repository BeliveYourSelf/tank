package com.mashibing.tank.dp.cor;/**
 * Created by Administrator on 2020/12/3 22:33
 */

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;
import com.mashibing.tank.dp.mediator.GameObject;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/3 22:33
 *
 * 责任链细节：责任链本身也可以作为其中的一个链条
 * @Param
 * @return
 **/
public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;

            if (b.rect.intersects(w.rect)) {
                b.die();
                return false;
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            collide(o2, o1);
        }
            return true;
    }
}
