package structures;

import structures.exception.ElementNotFoundException;
import structures.exception.EmptyCollectionException;

import java.util.Iterator;

public class DoubleList<T> implements ListADT<T> {

    protected DoubleNode<T> front, rear;
    protected int count;

    public DoubleList() {
        rear = null;
        front = null;
        count = 0;
    }

    private DoubleNode<T> find (T target) {
        boolean found = false;
        DoubleNode<T> traverse = front;
        DoubleNode<T> result = null;

        if (!isEmpty()) {
            while (!found && traverse != null) {
                if (target.equals(traverse.getElement())) {
                    found = true;
                } else {
                    traverse = traverse.getNext();
                }
            }
        }

        if (found) {
            result = traverse;
        }

        return result;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        T result = front.getElement();
        rear = rear.getPrevious();

        if (rear == null) {
            front = null;
        } else {
            rear.setNext(null);
        }

        count--;

        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        T result;
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        result = rear.getElement();
        rear = rear.getPrevious();

        if (rear == null) {
            front = null;
        } else {
            rear.setNext(null);
        }

        count--;

        return result;
    }

    @Override
    public T remove(T element) {
        T result;
        DoubleNode<T> nodePtr = find(element);

        if (nodePtr == null) {
            throw new ElementNotFoundException("list");
        }

        result = nodePtr.getElement();

        if (nodePtr == front) {
            result = this.removeFirst();
        } else if (nodePtr == rear) {
            result = this.removeLast();
        } else {
            nodePtr.getNext().setPrevious(nodePtr.getPrevious());
            nodePtr.getPrevious().setNext(nodePtr.getNext());
            count--;
        }

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        return front.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        return rear.getElement();
    }

    @Override
    public boolean contains(T target) {
        return find(target) != null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleIterator<>(front, count);
    }

    @Override
    public String toString() {
        String result = "";
        DoubleNode<T> traverse = front;

        while (traverse != null) {
            result = result + (traverse.getElement()).toString() + "\n";
            traverse = traverse.getNext();
        }

        return result;

    }
}
