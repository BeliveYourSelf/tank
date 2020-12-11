package com.mashibing.tank.dp.observer;/**
 * Created by Administrator on 2020/12/6 22:21
 */

import com.mashibing.tank.Tank;
import com.mashibing.tank.dp.strategy.DefaultFireStrategy;
import com.mashibing.tank.dp.strategy.FourFireStrategy;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/6 22:21
 * @Param
 * @return
 **/
public class TankFireHandler implements TankFireObserver {

    @Override
    public void actionOnFire(TankFireEvent event) {
        Tank t = event.getSource();
        t.fire(new FourFireStrategy());
    }
}
