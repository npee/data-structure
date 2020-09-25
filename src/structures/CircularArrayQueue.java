package structures;

//********************************************************************
//  CircularArrayQueue.java       Authors: Lewis/Chase
//
//  Represents an array implementation of a queue in which the
//  indexes for the front and rear of the queue circle back to 0
//  when they reach the end of the array.
//********************************************************************

import structures.exception.EmptyCollectionException;
import structures.exception.EmptyStackException;

public class CircularArrayQueue<T> implements QueueADT<T> {
    private final int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    public CircularArrayQueue() {
        front = rear = count = 0;
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public CircularArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = (T[]) new Object[initialCapacity];
    }

    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;

        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;

        count--;

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    public String toString() {
        String result = "";
        int scan = 0;

        while (scan < count) {
            if (queue[scan] != null) {
                result += queue[scan].toString() + "\n";
            }
            scan++;
        }
        return result;
    }

    public void expandCapacity() {
        T[] larger = (T[]) new Object[queue.length * 2];
        for (int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = larger;
    }
}
