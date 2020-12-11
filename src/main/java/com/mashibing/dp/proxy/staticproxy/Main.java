package com.mashibing.dp.proxy.staticproxy;/**
 * Created by Administrator on 2020/12/11 8:19
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/11 8:19
 * @Param
 * @return
 **/
public class Main {

    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy(new Car());
        staticProxy.move();
    }
}
