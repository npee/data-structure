package structures;

//********************************************************************
//  QueueADT.java       Authors: Lewis/Chase
//
//  Defines the interface to a queue collection.
//********************************************************************

public interface QueueADT<T> {

    public void enqueue (T element);
    public T dequeue();
    public T first();
    public boolean isEmpty();
    public int size();
    public String toString();
}
