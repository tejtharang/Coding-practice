package com.tej.StacksAndQueues;

import java.util.HashMap;
import java.util.Stack;

class StackNode{
    private Integer value;
    private Integer minimum;

    public Integer getValue() {
        return value;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public StackNode(Integer value, Integer minimum){
        this.value = value;
        this.minimum = minimum;
    }


}

public class MyStack extends Stack{
    private Stack<StackNode> stack = new Stack<>();
    private Integer min;

    public MyStack(){
        this.min = Integer.MAX_VALUE;
    }

    public int size(){
        return this.stack.size();
    }

    public void push(int item){
        this.min = Integer.min(this.min,item);
        this.stack.push(new StackNode(item,this.min));
    }

    public Integer pop(){
        this.min = this.stack.peek().getMinimum();
        return this.stack.pop().getValue();
    }

    public Integer getMin(){
        return this.stack.peek().getMinimum();
    }
}

