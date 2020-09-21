package structures;

//********************************************************************
//  ArrayStack.java       Authors: Lewis/Chase
//
//  Represents an array implementation of a stack.
//********************************************************************

import structures.exception.EmptyStackException;
import sun.invoke.empty.Empty;

public class ArrayStack<T> implements StackADT<T> {

    private final int DEFAULT_CAPACITY = 100;
    private int top; // indicates the next open slot
    private transient T[] stack;

    public ArrayStack() {
        top = 0;
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public String toString() {
        String result = "";
        for (int scan = 0; scan < top; scan++) {
            result = result + stack[scan].toString() + "\n";
        }
        return result;
    }

    public void expandCapacity() {
        T[] larger = (T[]) new Object[stack.length * 2];

        for (int index = 0; index < stack.length; index++) {
            larger[index] = stack[index];
        }
        stack = larger;
    }
}
