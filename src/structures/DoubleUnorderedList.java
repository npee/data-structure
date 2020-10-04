package structures;

import structures.exception.NonComparableElementException;

public class DoubleUnorderedList<T> extends DoubleList<T> implements OrderedListADT<T> {

    public DoubleUnorderedList() {
        super();
    }

    @Override
    public void add(T element) {
        Comparable temp;
        if (element instanceof Comparable) {
            temp = (Comparable) element;
        } else {
            throw new NonComparableElementException("double ordered list");
        }

        DoubleNode<T> traverse = front;
        DoubleNode<T> newNode = new DoubleNode<>(element);
        boolean found = false;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else if (temp.compareTo(rear.getElement()) >= 0) {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            newNode.setNext(null);
            rear = newNode;
        } else if (temp.compareTo(front.getElement()) <= 0) {
            front.setPrevious(newNode);
            newNode.setNext(front);
            newNode.setPrevious(null);
            front = newNode;
        } else {
            while (temp.compareTo(traverse.getElement()) > 0) {
                traverse = traverse.getNext();
                newNode.setNext(traverse);
                newNode.setPrevious(traverse.getPrevious());
                traverse.getPrevious().setNext(newNode);
                traverse.setPrevious(newNode);
            }
        }

        count++;
    }
}
