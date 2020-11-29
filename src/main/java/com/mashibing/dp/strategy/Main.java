package com.mashibing.dp.strategy;/**
 * Created by Administrator on 2020/11/29 11:01
 */

import java.util.Arrays;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 11:01
 * @Param
 * @return
 **/
public class Main {
    public static void main(String[] args) {
        Comparator<Cat> tComparator = (o1, o2) -> {
            if (o1.weight < o2.weight) return -1;
            else if (o1.weight < o2.weight) return 1;
            else return 0;
        };

//        int[] a = {5,8,6,2,4,6};
        Cat[] a = {new Cat(3,3),new Cat(4,4),new Cat(2,2)};
//        Dog[] a = {new Dog(3),new Dog(4),new Dog(2)};
//        Sorter<Dog> sorter = new Sorter();
        Sorter<Cat> sorter = new Sorter();
//        sorter.sort(a,new CatWeightComparator());
        sorter.sort(a,tComparator);
        System.out.println(Arrays.toString(a));
    }
}
