/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

/**
 *
 * @author bramo
 */


class DoublyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(E x) {
        Node newNode = new Node(x);
        newNode.foreLink = null;
        if (isEmpty()) {
            last = newNode;
        } else {
            first.backLink = newNode;
        }
        newNode.foreLink = first;
        first = newNode;
    }

    public void insertLast(E x) {
        Node newNode = new Node(x);
        newNode.foreLink = null;
        if (isEmpty()) {
            first = newNode;
        } else {
            last.foreLink = newNode;
            newNode.backLink = last;
        }
        last = newNode;
    }

    public E deleteFirst() {
        E t = first.data;
        if (first.foreLink == null) {
            last = null;
        } else {
            first.foreLink.backLink = null;
        }
        first = first.foreLink;
        return t;
    }

    public E deleteLast() {
        E t = last.data;
        if (first.foreLink == null) {
            first = null;
        } else {
            last.backLink.foreLink = null;
        }
        last = last.backLink;
        return t;
    }

    public boolean isEmpty() {
        return (first == null);
    }

}
