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
public class CatHeightComparator implements Comparator<Cat>{

    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.height < o2.height) return -1;
        else if(o1.height > o2.height) return 1;
        else return 0;

    }

}
