package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/6/2 22:28
 * @Description: 重建二叉树
 *              输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *              假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *              例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 *              则重建二叉树并返回。
 */
public class Solution4 {
    //一开始调用这个方法,pre代表前序遍历,in代表中序遍历
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in){
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //循环递归这个方法
    public static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if (startPre > endPre || startIn > endIn){
            return null;
        }
        //前序遍历的startPre上的数值作为树的根
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++){
            if (in[i] == pre[startPre]){
                //endPre参数的意思: i-startIn表示的是左子树的长度，再加上startPre就表示左子树结束的位置下标
                root.left = reConstructBinaryTree(pre, startPre+1, i-startIn+startPre, in, startIn, i-1);
                root.right = reConstructBinaryTree(pre, i-startIn+startPre+1, endPre, in, i+1, endIn);
                //结束循环,减少匹配次数
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode);

    }
}
