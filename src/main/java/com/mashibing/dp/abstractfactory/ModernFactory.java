package com.mashibing.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/29 22:19
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 22:19
 * @Param
 * @return
 **/
public class ModernFactory extends AbstarctFactory {

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVhicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
