package com.mashibing.dp.proxy.cjlibproxy;/**
 * Created by Administrator on 2020/12/9 20:20
 */

import com.mashibing.dp.proxy.jdkproxy.Movable;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/9 20:20
 * @Param
 * @return
 **/
public class Car implements Movable{

    @Override
    public void move() {

        System.out.println("**********move***********************");
        try {
            sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        System.out.println("**********stop***********************");
        try {
            sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
