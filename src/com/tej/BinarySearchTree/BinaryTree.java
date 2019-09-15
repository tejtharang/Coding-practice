package com.tej.BinarySearchTree;

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        Node left1 = new Node(1);
        Node left11 = new Node(-1);
        Node left12 = new Node(2);
        Node right1 = new Node(5);
        Node right11 = new Node(4);
        Node right12 = new Node(6);

        left1.setLeft(left11);
        left1.setRight(left12);
        right1.setLeft(right11);
        right1.setRight(right12);
        root.setLeft(left1);
        root.setRight(right1);
        //inorderTraversal(root);
        //preorderTraversal(root);
        //postorderTraversal(root);
        //System.out.println(height(root));
        System.out.println(balanced(root));
    }

    public static void inorderTraversal(Node node){
        if(node != null){
            if(node.getLeft() == null && node.getRight() == null)
                System.out.println(node.getValue());
            else{
                inorderTraversal(node.getLeft());
                System.out.println(node.getValue());
                inorderTraversal(node.getRight());
            }
        }
    }

    public static void postorderTraversal(Node node){
        if(node != null){
            if(node.getLeft() == null && node.getRight() == null)
                System.out.println(node.getValue());
            else{

                System.out.println(node.getValue());
                postorderTraversal(node.getLeft());
                postorderTraversal(node.getRight());
            }
        }
    }

    public static void preorderTraversal(Node node){
        if(node != null){
            if(node.getLeft() == null && node.getRight() == null)
                System.out.println(node.getValue());
            else{
                preorderTraversal(node.getLeft());
                preorderTraversal(node.getRight());
                System.out.println(node.getValue());
            }
        }
    }

    public static Integer height(Node node){
        if(node == null)
            return 0;
        if(node.getLeft() == null && node.getRight() == null)
            return 1;
        return 1 + Math.max(height(node.getLeft()),height(node.getRight()));
    }

    public static boolean balanced(Node node){
        if(node == null)
            return true;
        if(node.getLeft() == null && node.getRight() == null)
            return true;
        if(Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1)
            return true;
        return false;

    }


}
