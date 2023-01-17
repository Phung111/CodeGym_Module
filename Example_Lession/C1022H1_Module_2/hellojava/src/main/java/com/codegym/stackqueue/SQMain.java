package com.codegym.stackqueue;

import java.util.AbstractList;
import java.util.Stack;

public class SQMain {
    public static void main(String[] args) {
        /**
         Stack<String> stack = new Stack<>();
         stack.push("Cuong");
         stack.push("Phu");
         stack.push("Duy");

         // Thực hiện các hành động sau kết quả là gì
         System.out.println(stack.pop());
         System.out.println(stack.pop());
         System.out.println(stack.peek());
         System.out.println(stack.peek());


         int [] arr = {5, 1, 7, 8, 9, 0};
         MyStack  <Integer> stack1  = new MyStack<>();
         for( int i = 0; i< arr.length; i++){
         stack1.push(arr[i]);
         }
         for (int i = 0; i< arr.length; i++){
         arr[i] = stack1.pop();
         }
         for (int i = 0; i< arr.length; i++){
         System.out.print(arr[i] + " ");
         }
         **/

        int num = 17;
        MyStack<Integer> stack2 = new MyStack<>();
//        while(num/2 != 0){
//            int s = num%2;
//            stack2.push(s);
//            num = num /2;
//        }
//        stack2.push(num);
        int halfNum;
        do {
            halfNum = num / 2;
            int s = num % 2;
            stack2.push(s);
            num = num / 2;
        } while (halfNum != 0);
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }

        AbstractList<String> a;
    }
}
