package com.mashibing.tank.dp.composite;/**
 * Created by Administrator on 2020/12/8 21:32
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/8 21:32
 * @Param
 * @return
 **/
public class BranchNode extends Node {
    public String name;

    List<Node> nodes = new ArrayList<>();
    public BranchNode(String name) {
//        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void add(Node node) {
        nodes.add(node);
    }
}
