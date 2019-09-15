package com.tej.LinkedList;


public class MiddleElementOfLinkedList {
    public static int middleElement(LinkedList l){
        Node l1 = l.getHead();
        Node l2 = l.getHead();
        while(l1 != null && l1.getNext() != null){
            l1 = l1.getNext().getNext();
            l2 = l2.getNext();
        }

        return l2.getValue();
    }

    public static boolean checkForCycle(LinkedList l){
        Node l1 = l.getHead();
        Node l2 = l.getHead();
        while(l1 != null && l1.getNext() != null){
            l1 = l1.getNext().getNext();
            l2 = l2.getNext();

            if(l1.equals(l2))
                return true;
        }

        return false;
    }


    public static void main(String [] args){
        LinkedList l = new LinkedList(1);
        l.addNode(2);
        l.addNode(3);
        l.addNode(4);
        l.addNode(5);
        Node node = new Node(6);
        node.setNext(l.getHead());
        l.addNode(node);
        System.out.println(checkForCycle(l));

    }

}
