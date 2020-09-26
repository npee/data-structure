package structures;

//********************************************************************
//  ArrayQueue.java       Authors: Lewis/Chase
//
//  Represents an array implementation of a queue. The front of
//  the queue is kept at array index 0.
//********************************************************************

import structures.exception.EmptyCollectionException;

public class ArrayQueue<T> implements QueueADT<T> {

    private final int DEFAULT_CAPACITY = 100;
    private int rear;
    private T[] queue;

    public ArrayQueue() {
        rear = 0;
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayQueue(int initialCapacity) {
        rear = 0;
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            expandCapacity();
        }

        queue[rear] = element;
        rear++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        T result = queue[0];

        rear--;

        for (int scan = 0; scan < rear; scan++) {
            queue[scan] = queue[scan + 1];
        }

        queue[rear] = null;

        return result;

    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return queue[0];
    }

    @Override
    public boolean isEmpty() {
        return rear == 0;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public String toString() {
        String result = "";

        for (int scan = 0; scan < rear; scan++) {
            result = result + queue[scan].toString() + "\n";
        }

        return result;
    }

    private void expandCapacity() {
        T[] larger = (T[]) new Object[queue.length * 2];

        for (int scan = 0; scan < queue.length; scan++) {
            larger[scan] = queue[scan];
        }

        queue = larger;
    }
}
