package com.duuuhs.pointoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DMY
 * @Date: 2019/6/12 23:24
 * @Description:  输入一个整数数组,实现一个函数来调整该数组中数字的顺序,使得所有的奇数位于数组的前半部分,
 *                所有的偶数位于数组的后半部分,并保证奇数和奇数,偶数和偶数之间的相对位置不变.
 */
public class Solution13 {
    public static Integer[] swap(int[] arr){
        if (arr.length == 0 || arr == null){
            return null;
        }
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i : arr) {
            if (i%2 == 1){
                odds.add(i);
            } else {
                evens.add(i);
            }
        }
        odds.addAll(evens);
        Integer[] news = odds.toArray(new Integer[odds.size()]);
        return news;

    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5,6,8,10,7,9};
        Integer[] swap = swap(arr);
        for (int i : swap) {
            System.out.print(i + " ");//1 3 5 7 9 2 4 6 8 10
        }
    }
}
