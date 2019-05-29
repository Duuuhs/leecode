package com.duuuhs.pointoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: DMY
 * @Date: 2019/4/8 15:41
 * @Description:  (编程题) 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Solution3 {

    public static List printListFromTailToHead(ListNode listNode){
        Stack<Object> stack = new Stack<>();
        while (listNode != null ){
            stack.push(listNode.val);
            listNode = listNode.next;

        }
        List<Object> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode("1");
        listNode1.next = new ListNode("2");
        listNode1.next.next = new ListNode("3");
        listNode1.next.next.next = new ListNode("4");
        listNode1.next.next.next.next = new ListNode("5");

        List list = printListFromTailToHead(listNode1);
        System.out.println(list);
    }
}
