package com.tej.TreeSearches;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {
    private Integer value;
    private Node left;
    private Node right;

    public Node(){
        this.value = null;
        this.left = null;
        this.right = null;
    }
    public Node(Integer value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(Integer value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean depthFirstSearch(Integer value){
        Stack<Node> stack = new Stack<Node>();
        if(this != null)
            stack.push(this);
        while(!stack.isEmpty()){
            Node item = stack.pop();
            if(item.value != null && item.value.equals(value))
                return true;
            else{
                if(item.left != null)
                    stack.add(item.left);
                if(item.right != null)
                    stack.add(item.right);
            }
        }
        return false;
    }

    public boolean breadthFirstSearch(Integer value){
        Queue<Node> queue = new LinkedList<Node>();
        if(this != null)
            queue.add(this);
        while(!queue.isEmpty()){
            Node item = queue.poll();
            if(item.value != null && item.value.equals(value))
                return true;
            else{
                if(item.left != null)
                    queue.add(item.left);
                if(item.right != null)
                    queue.add(item.right);
            }
        }
        return false;

    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
