package com.mashibing.tank.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/29 21:31
 */

import com.mashibing.tank.dp.factorymethod.CarFactory;
import com.mashibing.tank.dp.factorymethod.Moveable;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 21:31
 * @Param
 * @return
 **/
public class Main {
    public static void main(String[] args) {
        AbstarctFactory f = new ModernFactory();
        Vehicle c =f.createVhicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();



    }
}
