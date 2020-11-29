package com.mashibing.dp.strategy;/**
 * Created by Administrator on 2020/11/29 11:10
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 11:10
 * @Param
 * @return
 **/
public class Cat implements Comparable<Cat>{
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }



    @Override
    public String toString() {
        return "Cat{" + "weight=" + weight + ", height=" + height + '}';
    }

    @Override
    public int compareTo(Cat o) {
        Cat c =  o;
        if(this.weight < c.weight) return -1;
        else if(this.weight == c.weight) return 0;
        else  return 1;
    }
}
