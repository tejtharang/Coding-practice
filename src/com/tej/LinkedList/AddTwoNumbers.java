package com.tej.LinkedList;




public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static int length(ListNode l){
        ListNode head = l;
        int count = 0;
        while(head != null){
            count++;
            head= head.next;
        }

        return count;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyhead = new ListNode(0);
        ListNode head = (length(l1) >= length(l2))? l1 : l2;
        dummyhead.next = head;

        while(l1!=null || l2!=null){
            int p = (l1 != null) ? l1.val : 0;
            int q = (l2 != null) ? l2.val : 0;
            int res = p + q + carry;
            carry = res/10;
            head.val = res%10;
            if(head.next != null){
                head = head.next;
            }

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }

        if(carry > 0){
            head.next = new ListNode(carry);
        }
        return dummyhead.next;
    }
    public static void main(String [] args){
        System.out.println(addTwoNumbers(new ListNode(5), new ListNode(5)));
    }
}
