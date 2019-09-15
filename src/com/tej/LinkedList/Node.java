package com.tej.LinkedList;

import java.util.Comparator;

public class Node implements Comparable<Node> {
    private int value;
    private Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public boolean equals(Node n1, Node n2){
        return n1.getValue() == n2.getValue();
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.getValue();
    }
}
