package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/4/8 13:08
 * @Description:(编程题) 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该
 * 整数。
 *
 *
 * 思路: 以左下角或者右上角为基准，分别与目标数进行比较。以左下角为基准时，大于右移，小于上移；
 *      以右上角为基准时，大于下移，小于左移。
 */

public class Solution1 {

    public boolean exist(int[][]arr, int element){
        int row = arr.length-1;
        int column = 0;
        System.out.println("左下角元素为：" + arr[row][column]);
        while (row >= 0 && column < arr[row].length){
            System.out.print(arr[row][column]+"=>");
            if (element > arr[row][column]){
                column++;
            } else if (element < arr[row][column]){
                row--;
            } else {
                return true;
            }
        }
        return false;


    }
    public static void main(String[] args) {
        int[][] a = {{1,3,5,7,9,11,13},{2,4,6,8,10,12,14},{15,16,17,18,19,20,21}};
        int element = 22;
        Solution1 solution = new Solution1();
        boolean exist = solution.exist(a, element);
        System.out.println(exist);
    }
}
