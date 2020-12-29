package com.mashibing.dp.proxy.asm;/**
 * Created by Administrator on 2020/12/14 19:49
 */

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/14 19:49
 * @Param
 * @return
 **/
public class T1 {
        int i =0;
        public static void m() {
            int i = 1;
            int k =0;
            k = k++;
            System.out.println(k);
        }

    public static void main(String[] args) {
        m();
    }

}
