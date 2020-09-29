package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleIterator<T> implements Iterator<T> {

    private int count;
    private DoubleNode<T> current;

    public DoubleIterator(DoubleNode<T> list, int size ) {
        current = list;
        count = size;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T result = current.getElement();
        current = current.getNext();

        return result;
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
