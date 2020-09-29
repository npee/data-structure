package _08_Josephus;

import java.util.ArrayList;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        int numPeople, gap, counter;
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of soldiers: ");
        numPeople = in.nextInt();
        in.nextLine();

        System.out.println("Enter the gap between soldiers: ");
        gap = in.nextInt();

        for (int count = 1; count <= numPeople; count++) {
            list.add(count);
        }
        counter = gap - 1;

        System.out.println("The order is: ");

        while (!list.isEmpty()) {
            System.out.println(list.remove(counter));
            numPeople = numPeople - 1;
            if (numPeople > 0) {
                counter = (counter + gap - 1) % numPeople;
            }
        }
    }
}
