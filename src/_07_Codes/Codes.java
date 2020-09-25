package _07_Codes;

import structures.CircularArrayQueue;

public class Codes {
    public static void main(String[] args) {
        int[] key = {5, 12, -3, 8, -9, 4, 10};
        Integer keyValue;

        String encoded = "", decoded = "";
        String message = "All programmers are playwrights and all computers are lousy actors.";

        CircularArrayQueue<Integer> keyQueue1 = new CircularArrayQueue<>();
        CircularArrayQueue<Integer> keyQueue2 = new CircularArrayQueue<>();

        for (int scan = 0; scan < key.length; scan++) {
            keyQueue1.enqueue(key[scan]);
            keyQueue2.enqueue(key[scan]);
        }

        for (int scan = 0; scan < message.length(); scan++) {
            keyValue = keyQueue1.dequeue();
            encoded += (char) ((int) message.charAt(scan) + keyValue);
            keyQueue1.enqueue(keyValue);
        }

        System.out.println("Encoded Message: \n" + encoded + "\n");

        for (int scan = 0; scan < encoded.length(); scan++) {
            keyValue = keyQueue2.dequeue();
            decoded += (char) ((int) encoded.charAt(scan) - keyValue);
            keyQueue2.enqueue(keyValue);
        }

        System.out.println("Decoded Message: \n" + decoded);
    }
}
