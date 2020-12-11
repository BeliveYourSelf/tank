package com.mashibing.tank.dp.composite;/**
 * Created by Administrator on 2020/12/8 21:34
 */

import java.util.List;

/**
 * @Author Administrator
 * @Description TODO
 * Date 2020/12/8 21:34
 * @Param
 * @return
 **/
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("branchNode0");
        LeftPage leftPage1 = new LeftPage("leftPage1");
        BranchNode branchNode1 = new BranchNode("branchNode1");
        BranchNode branchNode2 = new BranchNode("branchNode21");
        LeftPage leftPage2 = new LeftPage("leftPage21");
        root.add(leftPage1);
        root.add(branchNode1);
        branchNode1.add(leftPage2);
        branchNode1.add(branchNode2);

        tree(root,1);

    }

    private static void tree(Node node,int i) {
        for (int j = 0; j < i; j++) {
            node.p("--");
        }
        System.out.println(node.getName());


        if(node instanceof BranchNode){
            int k = ++i;
            for ( Node node1: ((BranchNode) node).nodes) {
                tree(node1,k);
            }
        }

    }
}
