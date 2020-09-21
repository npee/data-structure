package structures;

import structures.exception.ElementNotFoundException;
import structures.exception.EmptySetException;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Random;

public class ArraySet<T> implements SetADT<T> {

    private static Random rand = new Random();

    private final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;

    private int count;
    private T[] contents;

    public ArraySet() {
        count = 0;
        contents = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArraySet (int initialCapacity) {
        count = 0;
        contents = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T element) {
        if (!contains(element)) {
            if (size() == contents.length)
                expandCapacity();

            contents[count] = element;
            count++;
        }
    }

    public void addAll(SetADT<T> set) {
        Iterator<T> scan = set.iterator();

        while (scan.hasNext())
            add(scan.next());
    }

    @Override
    public T removeRandom() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        int choice = rand.nextInt(count);
        T result = contents[choice];

        contents[choice] = contents[count-1];
        contents[count-1] = null;
        count--;

        return result;
    }

    @Override
    public T remove(T element) throws EmptySetException, ElementNotFoundException {
        int search = NOT_FOUND;

        if (isEmpty())
            throw new EmptySetException();

        for (int index = 0; index < count && search == NOT_FOUND; index++)
            if (contents[index].equals(element))
                search = index;

        if (search == NOT_FOUND)
            throw new ElementNotFoundException(element.toString());

        T result = contents[search];

        contents[search] = contents[count-1];
        contents[count-1] = null;
        count--;

        return result;
    }

    @Override
    public SetADT<T> union(SetADT<T> set) {
        ArraySet<T> both = new ArraySet<T>();

        for (int index = 0; index < count; index++)
            both.add(contents[index]);

        Iterator<T> scan = set.iterator();
        while (scan.hasNext())
            both.add(scan.next());

        return both;
    }

    @Override
    public boolean contains(T target) {
        int search = NOT_FOUND;

        for (int index = 0; index < count && search == NOT_FOUND; index++)
            if (contents[index].equals(target))
                search = index;

        return (search != NOT_FOUND);
    }

    @Override
    public boolean equals(SetADT<T> set) {
        boolean result = false;
        ArraySet<T> temp1 = new ArraySet<T>();
        ArraySet<T> temp2 = new ArraySet<T>();
        T obj;

        if (size() == set.size()) {
            temp1.addAll(this);
            temp2.addAll(set);

            Iterator<T> scan = set.iterator();

            while (scan.hasNext()) {
                obj = scan.next();
                if (temp1.contains(obj)) {
                    temp1.remove(obj);
                    temp2.remove(obj);
                }
            }

            result = temp1.isEmpty() && temp2.isEmpty();
        }
        return result;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(contents, count);
    }

    private void expandCapacity() {
        T[] larger = (T[]) new Object[contents.length * 2];

        for (int index = 0; index < contents.length; index++)
            larger[index] = contents[index];

        contents = larger;
    }

    @Override
    public String toString() {
        String result = "";

        for (int index = 0; index < count; index++) {
            result = result + contents[index].toString() + "\n";
        }

        return result;
    }
}
