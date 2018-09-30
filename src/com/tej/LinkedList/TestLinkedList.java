package com.tej.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(3);
        linkedList.print();
        linkedList.addNode(4);
        linkedList.print();
        System.out.print(linkedList.length());
    }
}
