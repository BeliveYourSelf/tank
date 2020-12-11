package com.mashibing.dp.strategy;/**
 * Created by Administrator on 2020/11/29 11:27
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 11:27
 * @Param 泛型的使用
 * @return
 **/
public class Dog implements Comparable<Dog>{

    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" + "food=" + food + '}';
    }

    @Override
    public int compareTo(Dog o) {
        Dog d =  o;
        if(this.food < d.food) return -1;
        else if(this.food > d.food) return 1;
        else return 0;
    }
}
