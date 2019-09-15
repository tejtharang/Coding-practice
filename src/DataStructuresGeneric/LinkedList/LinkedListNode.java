package DataStructuresGeneric.LinkedList;

public class LinkedListNode<E> {
    private E val;
    private LinkedListNode<E> next;

    public LinkedListNode( E val) {
        this.val = val;
        this.next = null;
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }

    public LinkedListNode<E> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<E> next) {
        this.next = next;
    }
}
