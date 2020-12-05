package com.mashibing.tank;/**
 * Created by Administrator on 2020/11/28 22:04
 */

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/11/28 22:04
 * @Param
 * @return
 **/
public class PropertyMgr {
    static Properties  props = new Properties();
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if(props == null) return null;
        return props.get(key);
    }
    public static String getString(String key) {
        if(props == null) return null;
        return (String)props.get(key);
    }

    public static Integer getInteger(String key) {
        if(props == null) return null;
        return Integer.parseInt((String)props.get(key));
    }
    public static List<String> getList(String key) {
        if(props == null) return null;
        String s = (String) props.get(key);
        String[] split = s.split(",", 0);
        return Arrays.asList(split);
    }

    public static void main(String[] args) {
        System.out.println(props.getProperty("initTankCount"));
    }
}
