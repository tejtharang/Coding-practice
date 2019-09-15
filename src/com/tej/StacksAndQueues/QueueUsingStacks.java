package com.tej.StacksAndQueues;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacks(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(int item){
        stack1.push(item);
    }

    public Integer dequeue(){
        Integer ret = null;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        ret = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return ret;
    }
}
