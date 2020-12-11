package com.mashibing.tank.dp.composite;/**
 * Created by Administrator on 2020/12/8 21:30
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/8 21:30
 * @Param
 * @return
 **/
public class LeftPage extends Node{
    public String name;

    public LeftPage(String name) {
//        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
