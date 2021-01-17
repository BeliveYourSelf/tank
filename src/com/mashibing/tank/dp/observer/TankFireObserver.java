package com.mashibing.tank.dp.observer;/**
 * Created by Administrator on 2020/12/6 22:16
 */

import java.io.Serializable;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/6 22:16
 * @Param
 * @return
 **/
public interface TankFireObserver extends Serializable {

    public void actionOnFire(TankFireEvent event);
}
