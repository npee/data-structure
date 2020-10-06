package _11_SortingAndSearching;

public class SortingAndSearching<T extends Comparable> {

    // Sorting
    public void selectionSort(T[] data) {
        int min;
        T temp;
        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }

            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
        }
    }

    public void bubbleSort(T[] data) {
        int position, scan;
        T temp;

        for (position = data.length - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    temp = data[scan];
                    data[scan] = data[scan + 1];
                    data[scan + 1] = temp;
                }
            }
        }
    }

    public void insertionSort(T[] data) {
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;

            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }

            data[position] = key;
        }
    }



    // Searching
    public boolean linearSearch(T[] data, int min, int max, T target) {
        int index = min;
        boolean found = false;

        while (!found && index <= max) {
            if (data[index].compareTo(target) == 0) {
                found = true;
            }
            index++;
        }

        return found;
    }

    public boolean binarySearch(T[] data, int min, int max, T target) {
        boolean found = false;
        int mid = (min + max) / 2;

        if (data[mid].compareTo(target) == 0) {
            found = true;
        } else if (data[mid].compareTo(target) > 0) {
            if (min <= mid - 1) {
                found = binarySearch(data, min, mid, target);
            } else if (mid + 1 <= max) {
                found = binarySearch(data, mid + 1, max, target);
            }
        }

        return found;
    }
}
