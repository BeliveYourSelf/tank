package com.mashibing.dp.strategy;

/**
 * Created by Administrator on 2020/11/29 11:48
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1,T o2);
}
