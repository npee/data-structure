package structures;

//********************************************************************
//  IndexedListADT.java       Authors: Lewis/Chase
//
//  Defines the interface to an indexed list collection. Elements
//  are referenced by contiguous numeric indexes.
//********************************************************************

public interface IndexedListADT<T> extends ListADT<T> {
    public void add(int index, T element);
    public void set(int index, T element);
    public void add(T element);
    public T get(int index);
    public int indexOf(T element);
    public T remove(int index);
}
