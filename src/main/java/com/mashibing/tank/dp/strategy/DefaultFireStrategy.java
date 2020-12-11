package com.mashibing.tank.dp.strategy;/**
 * Created by Administrator on 2020/11/29 20:33
 */

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Tank;
import com.mashibing.tank.dp.decorator.RecDecorator;
import com.mashibing.tank.dp.decorator.TailDecorator;
import com.mashibing.tank.dp.facade.GameModel;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 20:33
 * @Param
 * @return
 **/
public class DefaultFireStrategy implements FireStrategy{

    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        // Bug   new Bullet 又加了一遍
      /*  GameModel.getInstance().add(new RecDecorator(
                new TailDecorator(
                new Bullet(bX,bY,t.dir,t.group))));*/

        new Bullet(bX,bY,t.dir,t.group);
    }
}
