package com.tej.BinarySearchTree;

public class Node {
    private Integer value;
    private Node left;
    private Node right;

    public Node(Integer i){
        this.value = i;
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
