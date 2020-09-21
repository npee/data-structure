package structures;

import structures.exception.EmptyStackException;

public class LinkedStack<T> implements StackADT<T> {

    // Field
    private int count; // indicates the next open slot
    private LinearNode<T> top;

    // Constructor(Empty Constructor)
    public LinkedStack() {
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of the stack.
     * @param element New object what is pushed onto the stack.
     */
    @Override
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at toe top of the stack,
     * @return a reference to it.
     * @throws EmptyStackException If the stack is empty.
     */
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getElement();
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
    public String toString() {
        String result = "";
        LinearNode current = top;
        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }
        return result;
    }
}
