package structures;

import structures.exception.ElementNotFoundException;
import structures.exception.EmptyCollectionException;

import java.util.Iterator;

public class LinkedList<T> implements ListADT<T> {

    protected int count;
    protected LinearNode<T> head, tail;

    public LinkedList() {
        count = 0;
        head = tail = null;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        LinearNode<T> result = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        count--;

        return result.getElement();
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        LinearNode<T> result = tail;
        tail = previous;
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        count--;

        return result.getElement();
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        boolean found = false;

        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current != null && !found) {
            if (element.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            throw new ElementNotFoundException("list");
        }

        if (size() == 1) {
            head = tail = null;
        } else if (current.equals(head)) {
            head = current.getNext();
        } else if (current.equals(tail)) {
            tail = previous;
            tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        count--;

        return current.getElement();
    }

    @Override
    public T first() {
        return head.getElement();
    }

    @Override
    public T last() {
        return tail.getElement();
    }

    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        boolean found = false;

        LinearNode<T> current = head;

        while (current != null && !found) {
            if (target.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }

        return found;
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
        return new LinkedIterator<>(head, count);
    }

    @Override
    public String toString() {
        LinearNode<T> current = head;
        String result = "";

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
        }

        return result;
    }
}
