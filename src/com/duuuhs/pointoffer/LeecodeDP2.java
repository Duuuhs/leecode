package com.ibm.callcenter.leetcode;

import java.util.Arrays;

/**
 *  <动态规划>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */

public class LeecodeDP2{

    /**
     * 使用一个二维数组，利用杨辉三角形，即每个位置的路径 = 该位置左边的路径 + 该位置上边的路径，计算每个位置的不同路径数目
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n ; j ++){
                if (i == 0){
                    arr[0][j] = 1;
                } else if (j == 0){
                    arr[i][0] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m-1][n-1];
    }


    /**
     * 利用一维数组进行计算
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        int arr[] = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                arr[j] += arr[j - 1];
            }
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths1(m, n));

    }
}
