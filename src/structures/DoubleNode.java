package structures;

//********************************************************************
//  DoubleNode.java       Authors: Lewis/Chase
//                          Mods : Davis
//
//  Represents a node in a doubly linked list.
//********************************************************************

public class DoubleNode<E> {
    private DoubleNode<E> next;
    private E element;
    private DoubleNode<E> previous;

    public DoubleNode() {
        next = null;
        element = null;
        previous = null;
    }

    public DoubleNode(E elem) {
        next = null;
        element = elem;
        previous = null;
    }

    public DoubleNode<E> getNext() {
        return next;
    }

    public DoubleNode<E> getPrevious() {
        return previous;
    }

    public void setNext(DoubleNode<E> dNode) {
        next = dNode;
    }

    public void setPrevious(DoubleNode<E> dNode) {
        previous = dNode;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E elem) {
        element = elem;
    }
}
