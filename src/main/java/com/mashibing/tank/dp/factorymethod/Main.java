package com.mashibing.tank.dp.factorymethod;/**
 * Created by Administrator on 2020/11/29 21:31
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 21:31
 *工厂方法：方便产品的扩展
 * msb：工厂方法就是抽象工厂中每个产品族只有一种产品
 * @Param
 * @return
 **/
public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.go();


    }
}
