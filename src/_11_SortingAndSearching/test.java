package _11_SortingAndSearching;

public class test {
    public static void main(String[] args) {
        Integer[] x = {5, 3, 9, 2, 7, 1};

        SortingAndSearching<Integer> sorts = new SortingAndSearching<>();

        System.out.println(sorts.linearSearch(x, 0, 5, 3));
    }
}
