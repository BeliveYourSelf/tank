package com.mashibing.dp.abstractfactory;/**
 * Created by Administrator on 2020/11/29 21:31
 */

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
