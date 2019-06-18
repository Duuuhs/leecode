package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/6/18 22:43
 * @Description: 输入两个单调递增的链表,输出两个链表合成后的链表,当然我们需要合成后的链表满足单调不减规则.
 */
public class Solution16 {
    public static ListNode Merge(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode merge = Merge(list1, list2);
        System.out.println(merge);//merge链表元素的值是1,2,3,4,5,6
    }
}
