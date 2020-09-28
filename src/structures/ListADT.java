package structures;

//********************************************************************
//  ListADT.java       Authors: Lewis/Chase
//
//  Defines the interface to a general list collection. Specific
//  types of lists will extend this interface to complete the
//  set of necessary operations.
//********************************************************************

import java.util.Iterator;

public interface ListADT<T> {
    public T removeFirst();
    public T removeLast();
    public T remove(T element);
    public T first();
    public T last();
    public boolean contains(T target);
    public boolean isEmpty();
    public int size();
    public Iterator<T> iterator();
    public String toString();
}
