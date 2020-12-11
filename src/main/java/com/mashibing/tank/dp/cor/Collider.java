package com.mashibing.tank.dp.cor;/**
 * Created by Administrator on 2020/12/3 22:32
 */

import com.mashibing.tank.dp.mediator.GameObject;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/3 22:32
 * 责任链:就是把各种策略拼接在一起
 * @Param
 * @return
 **/
public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
