package com.mashibing.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/29 22:12
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 22:12
 * 缺点：在扩展新的产品时，他的子类都要实现他的方法
 * 接口：名词
 * 抽象类：形容词
 * @Param
 * @return
 **/
public abstract class AbstarctFactory {
    abstract Food createFood();
    abstract Vehicle createVhicle();
    abstract  Weapon createWeapon();

}
