package com.mashibing.tank.dp.strategy;

import com.mashibing.tank.Tank;

/**
 * Created by Administrator on 2020/11/29 19:43
 */
@FunctionalInterface
public interface Fire {
     void fire(Tank tank);
}
