/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

import java.util.*;

/**
 *
 * @author bramo
 */
public class Deque<E> {

    private DoublyLinkedList<E> l;

    public Deque() {
        l = new DoublyLinkedList<>();
    }

    public void insertLeft(E x) {
        l.insertFirst(x);
        System.out.print("Inserted to Front ");
    }

    public void insertRight(E x) {
        l.insertLast(x);
        System.out.print("Inserted to Rear ");
    }

    public E deleteLeft() {
        return l.deleteFirst();
    }

    public E deleteRight() {
        return l.deleteLast();
    }

    public boolean isQueueEmpty() {
        return l.isEmpty();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
