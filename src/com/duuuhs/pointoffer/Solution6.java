package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/6/3 22:27
 * @Description: 旋转数组的最小数字.
 *               把一个数组最开始的若干个元素搬到数组的末尾,我们称之为数组的旋转.
 *               输入一个非减排序的数组的一个旋转,输出旋转数组的最小元素.
 *               例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转,该数组的最小值为1.
 *               NOTE: 给出的所有元素都大于0,若数组大小为0，请返回0.
 */

public class Solution6 {
    /*
     * 二分法的变化算法。
     */
    public static int findMinarr(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            //最后一定会剩下两个元素,这个时候返回最小值,结束循环.
            if (left + 1 == right){
                return  Math.min(arr[left], arr[right]);
            }
            int mid = (left + right)/2;
            if (arr[mid] > arr[left]){
                left = mid;
            }
            if (arr[mid] < arr[left]){
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,2};
        System.out.println(findMinarr(arr));
    }

}
