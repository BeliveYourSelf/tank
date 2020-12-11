package com.mashibing.dp.strategy;/**
 * Created by Administrator on 2020/11/29 11:02
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/29 11:02
 *
 * 
 * @Param
 * @return
 **/
public class Sorter<T> {


    public void sort(T[] arr,Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j <arr.length ; j++) {
                minPos = comparator.compare(arr[j],arr[minPos]) == -1?j:minPos;
            }
            swap(arr,i,minPos);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void sortComparable(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j <arr.length ; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1  ? j:minPos;
            }

            swapComparable(arr,i,minPos);
        }
    }

    private void swapComparable(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

     /*public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j <arr.length ; j++) {
                minPos = arr[j] < arr[minPos] ? j:minPos;
            }

            swap(arr,i,minPos);
        }
    }*/
}
