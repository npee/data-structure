package structures;

//********************************************************************
//  LinkedQueue.java       Authors: Lewis/Chase
//
//  Represents a linked implementation of a queue.
//********************************************************************

import structures.exception.EmptyCollectionException;

public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private LinearNode<T> front, rear;

    public LinkedQueue() {
        count = 0;
        front = rear = null;
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<>(element);

        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }

        rear = node;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = front.getElement();
        front = front.getNext();
        count--;

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        return front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "";
        LinearNode<T> current = front;

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }
}
