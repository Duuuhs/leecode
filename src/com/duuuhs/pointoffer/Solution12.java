package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/6/11 22:13
 * @Description: 给定一个double类型的浮点数base和int类型的整数exponent.求base的exponent次方.
 */
public class Solution12 {
    /*
     * 主要考虑一下几种情况:1.分母不能为零;
     *                   2.自然数的0次幂为0;
     *                   3.幂小于0要被1除.
     */
    public static double power(double base, int exponent){
        double result = 1.0;
        //0次幂为1
        if (exponent == 0 && base != 0){
            return 1;
        }
        //分母不能为0
        if (exponent <= 0 && base == 0){
            throw new RuntimeException();
        }
        //取绝对值
        int n = Math.abs(exponent);
        for (int i = 0; i < n; i++){
            result *= base;
        }
        //幂为负数,即出现分母
        if (exponent < 0){
            result = 1/result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 2));//4.0
        System.out.println(power(2, -2));//0.25
        System.out.println(power(2, 0));//1.0
        System.out.println(power(0, -2));//RuntimeException
    }
}
