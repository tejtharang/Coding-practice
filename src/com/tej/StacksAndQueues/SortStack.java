package com.tej.StacksAndQueues;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> mergesort(Stack<Integer> stack){
        if(stack.size() <= 1){
            return stack;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int count = 0;

        while(!stack.isEmpty()){
            if(count % 2 == 0){
                stack1.push(stack.pop());
            }
            else{
                stack2.push(stack.pop());
            }
            count++;
        }

        stack1 = mergesort(stack1);
        stack1 = reverse(stack1);
        stack2 = mergesort(stack2);
        stack2 = reverse(stack2);

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek() > stack2.peek()){
                stack.push(stack1.pop());
            }
            else{
                stack.push(stack2.pop());
            }
        }
        while(!stack1.isEmpty()){
            stack.push(stack1.pop());
        }

        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }

        return stack;
    }

    public static void printStack(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static Stack<Integer> sortWithOne(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<Integer>();
        while(!s1.isEmpty()){
            Integer tmp = s1.pop();
            if(!s1.isEmpty()){
                if(s1.peek() > tmp){
                    s2.push(s1.pop());
                    s1.push(tmp);
                    while(!s2.isEmpty()){
                        s1.push(s2.pop());
                    }
                }
                else{
                    s2.push(tmp);
                }
            }
            else{
                s2.push(tmp);
            }
        }
        return s2;
    }

    public static Stack<Integer> reverse(Stack<Integer> stack){
        Stack<Integer> ret = new Stack<Integer>();
        while(!stack.isEmpty()){
            ret.push(stack.pop());
        }
        return ret;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(9);
        stack.push(2);

        stack.push(8);
        stack.push(4);
        stack.push(7);
        stack.push(6);
        stack = sortWithOne(stack);
        printStack(stack);

    }
}
