package DataStructuresGeneric.Heap;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    private int [] items = new int[capacity];

    private int getLeftChildIndex(int index){
        return 2*index + 1;
    }

    private int getRightChildIndex(int index){
        return 2*index + 2;
    }

    private int getParentIndex(int index){
        return (index-1) /2;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private int parent(int index){
        return items[getParentIndex(index)];
    }

    private void swap(int i, int j){
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private void ensureCapacity(){
        if(size == capacity) {
            Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private int peek(){
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    private int poll(){
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    private void add(int item){
        ensureCapacity();
        items[size++] = item;
        heapifyUp();
    }

    private void heapifyUp(){
        int index = size - 1;
        while( hasParent(index) && parent(index) > items[index]){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] > items[smallerChildIndex]){
                swap(index,smallerChildIndex);

            }
            else{
                break;
            }
            index = smallerChildIndex;
        }
    }



}
