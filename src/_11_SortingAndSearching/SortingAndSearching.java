package _11_SortingAndSearching;

public class SortingAndSearching<T extends Comparable> {

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
}
