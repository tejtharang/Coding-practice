package DataStructuresGeneric.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList mylist = new LinkedList<Integer>();
        System.out.println(mylist.getLength());
        mylist.add(3);
        mylist.add(4);
        System.out.println(mylist.getLength());
        System.out.println(mylist);
        System.out.println(mylist);
    }
}
