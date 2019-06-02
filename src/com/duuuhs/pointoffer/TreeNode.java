package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/6/2 22:34
 * @Description:  二叉树的节点
 */
public class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
