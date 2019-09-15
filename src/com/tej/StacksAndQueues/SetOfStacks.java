package com.tej.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
    List<Stack<Integer>> listOfStacks = new ArrayList<>();
    final int THRESHOLD = 5;

    public void SetOfStacks(){
        this.listOfStacks.add(new Stack<Integer>());
    }

    public void setOfStacksPush(int item){
        Stack<Integer> topStack = this.listOfStacks.get(this.listOfStacks.size() - 1);
        if(topStack.size() < this.THRESHOLD) {
            topStack.push(item);
            this.listOfStacks.set(listOfStacks.size() -1, topStack);
        }
        else{
            Stack<Integer> newStack = new Stack<>();
            newStack.push(item);
            this.listOfStacks.add(newStack);
        }
    }

    public Integer setOfStacksPop(){
        Integer ret = null;
        Stack<Integer> topStack;
        if(!this.listOfStacks.isEmpty()){
            topStack = this.listOfStacks.get(this.listOfStacks.size() - 1);
            if(!topStack.isEmpty()){
                ret =  topStack.pop();
                this.listOfStacks.set(this.listOfStacks.size() -1, topStack);
            }
            else{
                if(this.listOfStacks.size() == 1){
                    return null;
                }
                this.listOfStacks.remove(this.listOfStacks.size() -1);
                topStack = this.listOfStacks.get(this.listOfStacks.size() - 1);
                ret = topStack.pop();
                this.listOfStacks.set(this.listOfStacks.size() - 1, topStack);
            }
        }
        return ret;
    }

}
