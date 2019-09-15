package DataStructuresGeneric.LinkedList;

public class LinkedList<E> {
    private Integer length = 0;
    private LinkedListNode<E> dummyhead = new LinkedListNode<>(null);
    private LinkedListNode<E> latest = null;

    public void add(E val){
        LinkedListNode<E> node = new LinkedListNode<>(val);
        if(this.length.equals(0)){
            this.latest = node;
            this.dummyhead.setNext(latest);
        }
        else{
            latest.setNext(node);
            latest = latest.getNext();
        }
        length++;
    }

    public Integer getLength(){
        return this.length;
    }

    public LinkedListNode<E> getHead(){
        return dummyhead.getNext();
    }
}
