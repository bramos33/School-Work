/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityarrayqueue;

/**
 *
 * @author bramo
 */
public class PElement<E> {

    private E item;
    private int priority;
    
    public PElement(E item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PElement [item=" + item + ", priority=" + priority + "]";
    }

}
