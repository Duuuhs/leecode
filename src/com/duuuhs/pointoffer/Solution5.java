package com.duuuhs.pointoffer;

import java.util.Stack;

/**
 * @Author: DMY
 * @Date: 2019/6/3 22:06
 * @Description:  用两个栈来实现一个队列,完成队列的Push和Pop操作.
 *                队列中的元素为int类型.
 */

public class Solution5 {
    public static class TwoStackToQueue{

     /*
      * 思路：stack1作为队尾,负责入队操作,stack2作为队头,负责出队操作.
      *      入队要注意判断stack1是否已满;出队要判断两栈是否都为空.
      */
      private int size;
      private Stack<Integer> stack1;
      private Stack<Integer> stack2;

      public TwoStackToQueue(int size) {
        this.size = size;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
      }

      //push
      public boolean push(int item){
          if (stack1.size() >= size){
              return false;
          }
          stack1.push(item);
          return true;
      }

      //pop
      public int pop(){
          if (stack1.isEmpty() && stack2.isEmpty()){
              return -1;
          }
          if (!stack2.isEmpty()){
              return stack2.pop();
          } else {
              while (!stack1.isEmpty()){
                  stack2.push(stack1.pop());
              }
              return stack2.pop();
          }
      }


    }

    public static void main(String[] args) {
        TwoStackToQueue tstq = new TwoStackToQueue(2);
        System.out.println(tstq.push(1));//true
        System.out.println(tstq.push(2));//true
        System.out.println(tstq.push(3));//false
        System.out.println(tstq.pop());//1
        System.out.println(tstq.pop());//2
        System.out.println(tstq.pop());//-1
    }
}
