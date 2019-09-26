/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityarrayqueue;
import java.util.*;

/**
 *
 * @author bramo
 */
public class PriorityArrayQueue<E> implements Cloneable {

    private PElement[] data;
    private int manyItems;
    private int front;
    private int rear;
    
    public PriorityArrayQueue() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = (PElement[]) new Object[INITIAL_CAPACITY];
    }
    
    public PriorityArrayQueue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity is negative: " + initialCapacity);
        }
        manyItems = 0;
        data = new PElement[initialCapacity];
    }
    public PriorityArrayQueue<E> clone() {
        PriorityArrayQueue<E> answer;

        try {
            answer = (PriorityArrayQueue<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable");
        }

        answer.data = data.clone();

        return answer;
    }
    
    public void add(PElement item) {
        data[++manyItems] = item;
        int pos = manyItems;
        while (pos != 1 && item.getPriority() > data[pos / 2].getPriority()) {
            data[pos] = data[pos / 2];
            pos /= 2;
        }
        data[pos] = item;
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

    public void ensureCapacity(int minimumCapacity) {
        PElement[] biggerArray;
        int n1, n2;

        if (data.length >= minimumCapacity)
        {
            return;
        } else if (manyItems == 0)
        {
            data = new PElement[minimumCapacity];
        } else if (front <= rear) {
            biggerArray = new PElement[minimumCapacity];
            System.arraycopy(data, front, biggerArray, front, manyItems);
            data = biggerArray;
        } else {

            biggerArray = new PElement[minimumCapacity];
            n1 = data.length - front;
            n2 = rear + 1;
            System.arraycopy(data, front, biggerArray, 0, n1);
            System.arraycopy(data, 0, biggerArray, n1, n2);
            front = 0;
            rear = manyItems - 1;
            data = biggerArray;
        }
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return (manyItems == 0);
    }

    private int nextIndex(int i) {
        if (++i == data.length) {
            return 0;
        } else {
            return i;
        }
    }

    public PElement remove() {
        if (manyItems == 0) {
            throw new NoSuchElementException("Queue underflow");
        }
        int parent, child;
        PElement answer, temp;

        answer = data[1];
        temp = data[manyItems--];

        parent = 1;
        child = 2;
        while (child <= manyItems) {
            if (child < manyItems && data[child].getPriority() < data[child + 1].getPriority()) {
                child++;
            }
            if (temp.getPriority() >= data[child].getPriority()) {
                break;
            }

            data[parent] = data[child];
            parent = child;
            child *= 2;
        }
        data[parent] = temp;

        return answer;
    }

    public int size() {
        return manyItems;
    }

    public void trimToSize() {
        PElement[] trimmedArray;
        int n1, n2;

        if (data.length == manyItems)
        {
            return;
        } else if (manyItems == 0) {
            data = new PElement[0];
        } else if (front <= rear) {
            trimmedArray = new PElement[manyItems];
            System.arraycopy(data, front, trimmedArray, front, manyItems);
            data = trimmedArray;
        } else {
            trimmedArray = new PElement[manyItems];
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
