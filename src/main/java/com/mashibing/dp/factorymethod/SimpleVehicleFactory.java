package com.mashibing.dp.factorymethod;/**
 * Created by Administrator on 2020/11/29 21:38
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 21:38
 * 简单工厂的可扩展性不好
 *
 * @Param
 * @return
 **/
public class SimpleVehicleFactory {
    public Car createCar() {
        //before new Car();
        return new Car();
    }
    public Broom createBroom() {
        return new Broom();
    }

    public Plane createPlane() {
        return new Plane();
    }
}
