package structures;

//********************************************************************
//  UnorderedListADT.java       Authors: Lewis/Chase
//
//  Defines the interface to an unordered list collection. Elements
//  are stored in any order the user desires.
//********************************************************************

public interface UnorderedListADT<T> extends ListADT<T> {
    public void addToFront(T element);
    public void addToRear(T element);
    public void addAfter(T element, T target);
}
