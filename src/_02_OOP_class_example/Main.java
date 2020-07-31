package _02_OOP_class_example;

public class Main {
    public static void main(String args[]) {
        Coin coin = new Coin();
        coin.flip();

        System.out.println("Coin: " + coin.toString());
    }
}
