package structures;

import structures.exception.ElementNotFoundException;

import java.util.Iterator;

public class LinkedIterator<T> implements Iterator<T> {

    private int count;
    private LinearNode<T> current;

    public LinkedIterator(LinearNode<T> collection, int size) {
        current = collection;
        count = size;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new ElementNotFoundException();
        T result = current.getElement();
        current = current.getNext();

        return result;
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
