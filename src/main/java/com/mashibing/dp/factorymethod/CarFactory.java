package com.mashibing.dp.factorymethod;/**
 * Created by Administrator on 2020/11/29 21:41
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 21:41
 * @Param
 * @return
 **/
public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }

}
