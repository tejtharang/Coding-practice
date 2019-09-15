package DataStructuresGeneric.Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> stack;
    Stack(){
        this.stack = new ArrayList<E>();
    }

    public void push(E val){
        this.stack.add(val);
    }

    public E pop(){
        E ret = null;
        if(!this.isEmpty()) {
            ret = this.stack.get(this.stack.size() - 1);
            this.stack.remove(this.stack.size() -1);
        }
        return ret;
    }

    public boolean isEmpty(){
       return this.stack.isEmpty();
    }

    public E top(){
        E ret = null;
        if(!this.isEmpty())
            ret = this.stack.get(this.stack.size()-1);
        return ret;
    }
}
