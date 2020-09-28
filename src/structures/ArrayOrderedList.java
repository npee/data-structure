package structures;

//********************************************************************
//  ArrayOrderedList.java       Authors: Lewis/Chase
//                              Mods   : JCD
//  Represents an array implementation of an ordered list.
//********************************************************************

public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {
    public ArrayOrderedList() {
        super();
    }

    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void add(T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        Comparable<T> temp = (Comparable<T>) element;

        int scan = 0;
        while (scan < rear && temp.compareTo(list[scan]) > 0) {
            scan++;
        }

        for (int scan2 = rear; scan2 > scan; scan2--) {
            list[scan2] = list[scan2 - 1];
        }

        list[scan] = element;
        rear++;
    }
}
