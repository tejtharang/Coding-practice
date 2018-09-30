package com.tej.TreeSearches;

public class Tree {
    public static void main(String [] args){
        Node root = new Node();
        root.setLeft(new Node(3));
        root.setRight(new Node());
        inOrder(root);
        //System.out.print(root.depthFirstSearch(3));
        //System.out.print(root.breadthFirstSearch(3));
    }

    public static void inOrder(Node node){
        if(node.getLeft() != null)
            inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        if(node.getRight() != null)
            inOrder(node.getRight());
    }
}
