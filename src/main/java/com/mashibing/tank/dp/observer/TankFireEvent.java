package com.mashibing.tank.dp.observer;/**
 * Created by Administrator on 2020/12/6 22:15
 */

import com.mashibing.tank.Tank;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/6 22:15
 * @Param
 * @return
 **/
public class TankFireEvent {
    Tank tank;
    public Tank getSource() {
        return tank;
    }
    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}
