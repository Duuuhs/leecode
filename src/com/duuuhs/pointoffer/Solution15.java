package com.duuuhs.pointoffer;

import java.util.List;

/**
 * @Author: DMY
 * @Date: 2019/6/15 22:42
 * @Description:  输入一个链表,反转链表后,输出新链表的表头.
 */
public class Solution15 {


    /*
     * 是中分为两部分,一部分是已经反转的,用pre表示,一部分是为反转的,用next表示
     */
    public static ListNode reverseList(ListNode head){
        if (head == null){
            return null;
        }
        //head为当前节点,pre为前一节点,next为后一个节点
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            //先用next节点保存head的下一个节点的信息,避免因为反向指向导致链表断裂
            next = head.next;
            //head的下一个节点反向指向前一个节点,实现一个反转
            head.next = pre;

            //为下一个循环做准备,此时需要将pre指向为head,head指向为待反转的下一个节点
            pre = head;
            head = next;

        }
        //循环结束,此时的head为null,因此需要返回pre
        return pre;
    }


    public static ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode reversedHead=null;
        ListNode current=head;
        ListNode tmp=null;
        ListNode pre=null;
        while(current!=null){
            tmp=current.next;
            current.next=pre;
            if(tmp==null)
                reversedHead=current;
            pre=current;
            current=tmp;

        }
        return reversedHead;

}


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        ListNode listNode = ReverseList(head);
        ListNode listNode1 = reverseList(head);
        System.out.println(listNode1.val);
    }
}
