package _11_SortingAndSearching;

public class test {
    public static void main(String[] args) {
        Integer[] x = {5, 3, 9, 2, 7, 1};

        SortingAndSearching<Integer> sorts = new SortingAndSearching<>();

        System.out.println(sorts.linearSearch(x, 0, 5, 3));

        printArray(x);
        // sorts.selectionSort(x);
        sorts.bubbleSort(x);
        printArray(x);

        System.out.println(sorts.binarySearch(x, 0, 5, 3));

    }

    public static <T> void printArray(T[] array) {
        StringBuilder s = new StringBuilder();
        for (int scan = 0; scan < array.length; scan++) {
            s.append(array[scan]).append(" ");
        }
        System.out.println(s);
    }
}
