package com.tej.LinkedList;

public class LinkedList {
    private Node head;

    public LinkedList(Node head){
        this.head = head;
    }

    public LinkedList(int value){
        Node head = new Node(value);
        this.head = head;
    }

    public void addNode(int value){
        Node traveller = this.head;
        while(traveller.getNext() != null){
            traveller = traveller.getNext();
        }
        traveller.setNext(new Node(value));
    }

    public Node getHead(){
        return this.head;
    }

    public int length(){
        int count = 0;
        Node traverse = head;
        while(traverse != null){
            count++;
            traverse = traverse.getNext();
        }
        return count;
    }

    public void print(){
        Node traverse = head;
        while(traverse != null){
            System.out.print(traverse.getValue() + " ");
            traverse = traverse.getNext();
        }

    }
}
