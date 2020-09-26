package _07_RadixSort;

import structures.ArrayQueue;

public class RadixSort {
    public static void main(String[] args) {
        int[] list = {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241, 6589, 6622, 1211};

        String temp;
        Integer numObj;
        int digit, num;

        ArrayQueue<Integer>[] digitQueues = (ArrayQueue<Integer>[]) new ArrayQueue[10];

        for (int digitVal = 0; digitVal <= 9; digitVal++) {
            digitQueues[digitVal] = new ArrayQueue<>();
        }

        for (int position = 0; position <= 3; position++) {
            for (int scan = 0; scan < list.length; scan++) {
                temp = String.valueOf(list[scan]);
                digit = Character.digit(temp.charAt(3-position), 10);
                digitQueues[digit].enqueue(list[scan]);
            }

            num = 0;
            for (int digitVal = 0; digitVal <= 9; digitVal++) {
                while (!digitQueues[digitVal].isEmpty()) {
                    numObj = digitQueues[digitVal].dequeue();
                    list[num] = numObj;
                    num++;
                }
            }
        }

        for (int scan = 0; scan < list.length; scan++) {
            System.out.println(list[scan]);
        }



    }
}
