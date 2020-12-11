package com.mashibing.dp.proxy.staticproxy;/**
 * Created by Administrator on 2020/12/11 8:22
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/11 8:22
 * @Param
 * @return
 **/
public class StaticProxy implements Movable{

    Car car;

    public StaticProxy(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
