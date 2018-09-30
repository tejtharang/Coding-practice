package com.tej.LinkedList;

public class LinkedListFunctions {
    public static int lPalin(Node A) {
        Node head = A;
        Node curr = head;
        Node fast = head;
        Node temp = null;
        while(fast!=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            curr = head;
            head = curr.getNext();
            curr.setNext(temp);
            temp = curr;
        }
        if(fast != null)
            head = head.getNext();
        while(temp!= null && temp.getValue()==head.getValue()){
            temp = temp.getNext();
            head = head.getNext();
        }
        if(head == null)
            return 1;
        return 0;

    }

    public static void print(Node head){
        while(head!=null){
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
    }

    public static Node removeDuplicates(Node head){
        if(head == null)
            return null;
        Node ret = head;
        Node curr = head.getNext();
        Node duplicatecurr = head;
        while(curr != null && curr.getNext()!=null){
            if(curr.getValue() != duplicatecurr.getValue()) {
                duplicatecurr.setNext(curr);

            }
            curr = curr.getNext();
        }
        return ret;


    }

    public static Node reverse(Node head) {
        Node curr = head;
        Node temp = null;
        while (head != null) {
            curr = head;
            head = curr.getNext();
            curr.setNext(temp);
            temp = curr;
        }
        return curr;

    }

    public static void main(String[] args) {
        Node last = new Node(6);
        Node last4 = new Node(4, last);
        Node last3 = new Node(4, last4);
        Node last2 = new Node(4, last3);
        Node last1 = new Node(1, last2);

        Node head = removeDuplicates(last1);
        print(head);
        //System.out.println(lPalin(last1));
    }
}
