package com.mashibing.dp.strategy;/**
 * Created by Administrator on 2020/11/29 11:56
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 11:56
 * @Param
 * @return
 **/
public class DogComparator implements Comparator<Dog>{

    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.food < o2.food) return -1;
        else if(o1.food > o2.food) return 1;
        else return 0;
    }

}
