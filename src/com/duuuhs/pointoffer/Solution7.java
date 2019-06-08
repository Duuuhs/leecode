package com.duuuhs.pointoffer;

import java.util.Optional;

/**
 * @Author: DMY
 * @Date: 2019/6/3 23:08
 * @Description: 输出斐波那契数列第n项
 */
public class Solution7 {

    //方法1:递归,递归情况下有些n会出现stack溢出情况
    public static int Fibonacci1(int n){
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            return Fibonacci1(n-1) + Fibonacci1(n-2);
        }
    }

    //方法2:循环
    public static int Fibonacci2(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int prePreNum = 0;
        int preNum = 1;
        int result = 0;
        for (int i = 2; i <= n; i++){
            result = preNum + prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(Fibonacci1(n));
        System.out.println(Fibonacci2(n));


    }
}
