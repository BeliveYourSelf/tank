package com.mashibing.dp.proxy.jdkproxy;/**
 * Created by Administrator on 2020/12/9 20:21
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/9 20:21
 * @Param
 * @return
 **/
public class Main {

    public static void main(String[] args) {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Movable o =(Movable) Proxy.newProxyInstance(Car.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(System.currentTimeMillis());
                System.out.println(method.getName());
                method.invoke(new Car(), args);
                return null;
            }
        });
        o.move();
        o.stop();
    }

}
