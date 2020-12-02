package com.mashibing.tank.dp.strategy;

import com.mashibing.tank.Tank;
import com.mashibing.tank.dp.abstractfactory.BaseTank;

/**
 * Created by Administrator on 2020/11/29 20:31
 */
public interface FireStrategy {
    void fire(Tank tank);
}
