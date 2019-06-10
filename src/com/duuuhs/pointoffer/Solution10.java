package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/6/10 23:01
 * @Description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形.
 *               请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形,总共有多少种方法?
 */
public class Solution10 {
    /*
     * 同样是斐波那契数列.
     * n>=3的时候,有两种情况,第一种是在n-1的情况下再多加一个2*1的小矩阵,该情况的排列数量与n-1的一致;
     * 第二种是在n-2的情况下再多加两个2*1的小矩阵,此时由于一个小矩阵确定了,另一个的位置也跟着确定,所以该情况的排列数量与n-2的一致。
     */
    public static int coverMatrix(int n){
        if (n < 0){
            return -1;
        }
        int[] fib = {0, 1, 2};
        if (n < 3){
            return fib[n];
        }
        int sum = 0;
        int prePreNum = 1;
        int preNum = 2;
        for (int i = 3; i <= n; i++){
            sum = preNum + prePreNum;
            prePreNum = preNum;
            preNum = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(coverMatrix(n));
    }
}
