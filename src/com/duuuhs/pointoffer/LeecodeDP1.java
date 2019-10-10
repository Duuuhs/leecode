package com.ibm.callcenter.leetcode;

/**
 *  <动态规划>
 *  给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *  示例 1：
 *  输入: "babad"
 *  输出: "bab"
 *  注意: "aba" 也是一个有效答案。
 *  示例 2：
 *  输入: "cbbd"
 *  输出: "bb"
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class LeecodeDP1 {

    /**
     * 中心拓展法
     * 时间复杂度：O(n^2)，由于围绕中心来扩展回文会耗去 O(n)O(n) 的时间，所以总的复杂度为 O(n^2)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s){
        if (null == s || s.length() <= 0){
            return "";
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > right - left){
                left = i - (len - 1)/2;
                right = i + len/2;
            }
        }
        //substring是左闭右开类型
        return s.substring(left, right+1);
    }

    /**
     * 该方法以left和right确定一个中心点，然后进行中心拓展
     * 一共有2n-1个中心点，因为中心点有可能处于某个数，也有可能处于两个数的间隙中
     * @param s
     * @param left
     * @param right
     * @return
     */
    public static int expandAroundCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        String ss = "";
        System.out.println(longestPalindrome(ss));
    }
}
