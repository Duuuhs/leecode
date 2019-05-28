package com.duuuhs.pointoffer;

import java.util.Arrays;

/**
 * @Author: DMY
 * @Date: 2019/4/8 15:14
 * @Description:(编程题) 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为
 *                       We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {

    public static String change(String target){
        String[] split = target.split(" ");
        System.out.println(Arrays.asList(split).toString());
        String change = "";
        for (int a = 0; a < split.length; a++){
            if (a == split.length-1){
                change += split[a];
            } else {
                String parm = split[a] + "%20";
                change += parm;
            }
        }
//        target.replaceAll(" ", "%20");  直接替换
        return change;

    }

    public static void main(String[] args) {
        String target = "We Are Happy.";
        String change = change(target);
        System.out.println(change);
    }
}
