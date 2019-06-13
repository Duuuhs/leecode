package com.duuuhs.pointoffer;

/**
 * @Author: DMY
 * @Date: 2019/6/13 23:13
 * @Description: 输入一个链表,输出该链表中倒数第k个结点.
 */

public class Solution14 {
    /*
     * 整体思路：可以理解为制造了一个K长度的尺子,把尺子从头往后移动,当尺子的右端与链表的末尾对齐的时候,
     *         尺子左端所在的结点就是倒数第k个结点！
     * 代码思路：两个指针,先让第一个指针和第二个指针都指向头结点,然后再让第一个指正走(k-1)步,到达第k个节点.
     *         然后两个指针同时往后移动,当第一个结点到达末尾的时候,第二个结点所在位置就是倒数第k个节点了.
     */
    public static ListNode FindLastKMember(ListNode head, int k){
        if (head == null || k <= 0){
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        for (int i = 1; i< k; i++){
            if (right.next != null){
                right = right.next;
            }
        }
        while (right.next != null){
            left = left.next;
            right = right.next;
        }
        return left;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode listNode = FindLastKMember(head, 2);
        System.out.println(listNode.val);//5
    }

}
