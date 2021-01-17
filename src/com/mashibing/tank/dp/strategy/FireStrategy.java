package com.mashibing.tank.dp.strategy;

import com.mashibing.tank.Tank;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/11/29 20:31
 */
public interface FireStrategy extends Serializable {
    void fire(Tank tank);
}
