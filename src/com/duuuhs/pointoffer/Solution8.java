package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/6/8 23:49
 * @Description:  一只青蛙一次可以跳上1级台阶,也可以跳上2级.求该青蛙跳上一个n级的台阶总共有多少种跳法.
 */
public class Solution8 {
    /*
     * 该问题实质是斐波那契数列求和,递推公式为 f(n)=f(n-1)+f(n-2);
     * 可以考虑,小青蛙每一步跳跃只有两种选择:一是再跳一级阶梯到达第 i 级阶梯,此时小青蛙处于第 i-1 级阶梯;
     * 或者再跳两级阶梯到达第 i 级阶梯,此时小青蛙处于第 i-2 级阶梯.
     * 于是,i 级阶梯的跳法总和依赖于前 i-1 级阶梯的跳法总数f(i-1)和前 i-2 级阶梯的跳法总数f(i-2).
     * 因为只有两种可能性,所以，f(i)=f(i-1)+f(i-2);
     * 依次类推,可以递归求出n级阶梯跳法之和.
     */
    public static int jumpFloor(int n){
        if (n < 0){
            return -1;
        }
        int[] fib = {0,1,2};
        if (n <= 2){
            return fib[n];
        }
        int sum = 0;
        int preJumpFloor = 2;
        int prePreJumpFloor = 1;
        for (int i = 3; i <= n; i++){
            sum = preJumpFloor + prePreJumpFloor;
            prePreJumpFloor = preJumpFloor;
            preJumpFloor = sum; //preJumpFloor += prePreJumpFloor;
        }
        return sum;
    }



    public static void main(String[] args) {
        int n = 4;
        System.out.println(jumpFloor(n));
    }
}
