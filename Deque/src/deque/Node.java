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
public class Node<E> {

    public E data;
    public Node<E> foreLink;
    public Node<E> backLink;

    public Node(E x) {
        data = x;
    }
}
