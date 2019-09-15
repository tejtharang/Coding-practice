package com.tej.LinkedList;

import java.util.HashSet;
import java.util.Set;

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
        while(curr != null ){
            if(curr.getValue() != duplicatecurr.getValue()) {
                duplicatecurr.setNext(curr);

            }
            curr = curr.getNext();
        }
        duplicatecurr.setNext(curr);
        return ret;
    }

    public static Node removeDuplicatesWithoutHashing(Node head){
        if(head == null){
            return null;
        }
        Node current = head;
        Node prev;
        Node runner;

        while(current != null){
            prev = current;
            runner = current.getNext();

            while(runner != null){
                if(current.getValue() == runner.getValue()){
                    runner = runner.getNext();
                    prev.setNext(runner);
                }
                else{
                    prev = runner;
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
        return head;
    }

    public static Node removeMyDuplicates(Node head){
        if(head == null)
            return head;
        Node ret = head;
        Node p = null;
        Set<Node> set = new HashSet<>();
        while(head != null){
            if(!set.contains(head)){
                set.add(head);

            }
            else{
                head = head.getNext();
                p.setNext(head);
            }

            p = head;
            head = head.getNext();
        }
        return ret;
    }

    public static Node reverse(Node head) {
        Node p = null;
        Node t;
        while(head != null){
            t = head.getNext();
            head.setNext(p);
            p = head;
            head = t;
        }

        return p;
    }

    // method to add two linkedlists
    public static Node add(Node head1, Node head2){
        head1 = reverse(head1);
        head2 = reverse(head2);
        int carry=0,val;
        Node newhead = null;
        Node added = null;
        boolean flag = true;
        while(head1 != null && head2 != null){
            val = head1.getValue() + head2.getValue() + carry;
            carry = 0;

            if(val > 9)
                carry = 1;


            if(flag){
                newhead = new Node(val%9);
                added = newhead;

                flag = false;
            }
            else{
                added.setNext(new Node(val%9));
                added = added.getNext();
            }

            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        while(head1 != null){
            val = head1.getValue() + carry;
            carry = 0;

            if(val > 9)
                carry = 1;

            if(flag){
                newhead = new Node(val%9);
                added = newhead;

                flag = false;
            }
            else{
                added.setNext(new Node(val%9));
                added = added.getNext();

            }

            head1 = head1.getNext();
        }

        while(head2 != null){
            val = head2.getValue() + carry;
            carry = 0;

            if(val > 9)
                carry = 1;

            if(flag){
                newhead = new Node(val%9);
                added = newhead;

                flag = false;
            }
            else{
                added.setNext(new Node(val%9));
                added = added.getNext();

            }

            head2 = head2.getNext();
        }

        newhead = reverse(newhead);
        return newhead;
    }

    public static Node kthNode(Node head, int k){
        int count = 1;
        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.getNext() != null){
            if(count >= k)
                turtle = turtle.getNext();
            hare = hare.getNext();
            count++;
        }
        if(count >= k){
            return turtle;
        }
        return null;
    }

    public static boolean palindrome(Node head){
        Node hare = head;
        Node turtle = head;
        Node prev = null;
        Node t;

        while(hare != null && hare.getNext() != null){
            hare = hare.getNext().getNext();
            t = turtle.getNext();
            turtle.setNext(prev);
            prev = turtle;
            turtle = t;
        }

        if(hare.getNext() == null ){
            turtle = turtle.getNext();
        }

        while(prev != null && turtle  != null){
            if(turtle.getValue() != prev.getValue()){
                return false;
            }
            prev = prev.getNext();
            turtle = turtle.getNext();
        }
        return true;
    }

    public static Node partition(Node head, int k){
        Node before = null;
        Node beforehead = null;
        Node after = null;
        Node afterhead = null;
        while(head != null){
            Node next = head.getNext();
            head.setNext(null);
            if(head.getValue() < k){
                if(before == null){
                    before = head;
                    beforehead = before;
                }
                else{
                    before.setNext(head);
                    before = before.getNext();
                }
            }
            else{
                if(after == null){
                    after = head;
                    afterhead = after;
                }
                else{
                    after.setNext(head);
                    after = after.getNext();
                }
            }

            head = next;
        }

        before.setNext(afterhead);
        return beforehead;
    }

    public static int getLength(Node head){
        Node traveller = head;
        int count = 0;
        while(traveller.getNext()!=null){
            traveller = traveller.getNext();
            count++;
        }

        return count;
    }

    public static Node getIntersectionNode(Node head1, Node head2){
        Node intersection;
        Node c1 = head1;
        Node c2 = head2;
        int l1 = getLength(c1);
        int l2 = getLength(c2);
        if(l1 > l2){
            intersection = getNode(l1-l2, head1,head2);
        }
        else{
            intersection = getNode(l2-l1,head2,head1);
        }

        return intersection;
    }

    public static Node getNode(int d, Node h1, Node h2){
        Node ret = null;
        while(d > 0){
            if(h1!= null){
                h1 = h1.getNext();
                d--;
            }
            else{
                break;
            }
        }

        while(h1 != null && h2 != null){
            if(h1.equals(h2)){
                ret = h1;
                break;
            }
            else{
                h1 = h1.getNext();
                h2 = h2.getNext();
            }
        }
        return ret;
    }

    public static Node circularLinkedListBeginningNode(Node head){
        Node hare = head;
        Node turtle = head;

        while(hare != null && hare.getNext() != null){
            hare = hare.getNext().getNext();
            turtle = turtle.getNext();
            if(hare.equals(turtle)){
                return turtle;
            }
        }

        return turtle;
    }
    public static void main(String[] args) {

        //Node second = new Node(2);

        //Node last3 = new Node(3);
        //Node last2 = new Node(4, last3);
        //Node last1 = new Node(1, last2);

        //Node added = add(last1, second);
        //print(added);
        //Node head = removeDuplicates(last1);
        //Node head = removeDuplicatesWithoutHashing(last1);
        //print(head);
        //print(head);

        //Node head1 = reverse(last1);
        //print(head1);
        //System.out.println(lPalin(last1));
        //System.out.println(kthNode(last1,2).getValue());
        /*LinkedList list = new LinkedList(9);
        list.addNode(8);
        list.addNode(8);
        list.addNode(6);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.addNode(8);
        list.addNode(9);*/

        LinkedList l1 = new LinkedList(500);
        LinkedList l2 = new LinkedList(400);

        l1.addNode(499);
        l1.addNode(399);
        Node in = new Node(6999);
        in.setNext(new Node(9999));
        l1.addNode(in);
        l2.addNode(in);

        Node head = getIntersectionNode(l1.getHead(),l2.getHead());
        //Node newhead = partition(head,5);
        //System.out.println(palindrome(head));
        System.out.println(head.getValue());
    }

}
