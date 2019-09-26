/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayqueue;

import java.util.*;

/**
 *
 * @author bramo
 */
public class ArrayQueue<E> implements Cloneable {

    private Object[] data;
    private int manyItems;
    private int front;
    private int rear;

    public ArrayQueue() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = new Object[INITIAL_CAPACITY];
    }

    public ArrayQueue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity can not be negative" + initialCapacity);
        }
        manyItems = 0;
        data = new Object[initialCapacity];
    }

    public void add(E item) {
        if (manyItems == data.length) {
            ensureCapacity(manyItems * 2 + 1);
        }
        if (manyItems == 0) {
            front = 0;
            rear = 0;
        } else {
            rear = nextIndex(rear);
        }
        data[rear] = item;
        manyItems++;
    }

    public ArrayQueue<E> clone() {
        ArrayQueue<E> answer;

        try {
            answer = (ArrayQueue<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement cloneable");
        }

        answer.data = data.clone();
        return answer;
    }
    
    public int getCapacity() {
        return data.length;
    }
    
    public boolean isEmpty() {
        return(manyItems == 0);
    }
    
    private int nextIndex(int i){
        if(i == data.length - 1){
            return 0;
        }
        else{
            return i++;
        }
    }
    
    public void ensureCapacity(int minimumCapacity) {
        Object[] biggerArray;
        int n1, n2;
        
        if(data.length >= minimumCapacity){
            return;
        }
        else if(front <= rear){
            biggerArray = new Object[minimumCapacity];
            System.arraycopy(data, front, biggerArray, front, manyItems);
            data = biggerArray;
        }
        else{
            biggerArray = new Object[minimumCapacity];
            n1 = data.length - front;
            n2 = rear + 1;
            System.arraycopy(data, front, biggerArray, 0, n1);
            System.arraycopy(data, 0, biggerArray, n1, n2);
            front = 0;
            rear = manyItems - 1;
            data = biggerArray;
        }
    }
    
    @SuppressWarnings("unchecked")
    public E remove() {
        E answer;
        
        if(manyItems == 0){
            throw new NoSuchElementException("Queue underflow.");
        }
        
        answer = (E) data[front];
        front = nextIndex(front);
        manyItems--;
        return answer;

    }

    public int size() {
        return manyItems;
    }
    
    public void trimToSize() {
        Object[] trimmedArray;
        int n1, n2;
        
        if(data.length == manyItems){
            return;
        }
        else if(manyItems == 0){
            data = new Object[0];
        }
        else if(front <= rear){
            trimmedArray = new Object[manyItems];
            System.arraycopy(data, front, trimmedArray, front, manyItems);
            data = trimmedArray;
        }
        else{
            trimmedArray = new Object[manyItems];
            n1 = data.length - front;
            n2 = rear + 1;
            System.arraycopy(data, front, trimmedArray, 0, n1);
            System.arraycopy(data, 0, trimmedArray, n1, n2);
            front = 0;
            rear = manyItems - 1;
            data = trimmedArray;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        // TODO code application logic here
    }

}
