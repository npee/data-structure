package structures;

//********************************************************************
//  OrderedListADT.java       Authors: Lewis/Chase
//
//  Defines the interface to an ordered list collection. Only
//  Comparable elements are stored, kept in the order determined by
//  the inherent relationship among the elements.
//********************************************************************

public interface OrderedListADT<T> extends ListADT<T> {
    public void add(T element);
}
