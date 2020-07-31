package _03_01_ArratSet;

public class Bingo {
    public static void main(String[] args) {
        final int NUM_BALLS = 75, NUM_PULLS = 10;

        ArraySet<BingoBall> bingoSet = new ArraySet<BingoBall>();
        BingoBall ball;

        for (int num = 1; num <= NUM_BALLS; num++) {
            ball = new BingoBall(num);
            bingoSet.add(ball);
        }

        System.out.println("Size: " + bingoSet.size());
        System.out.println();

        for (int num = 1; num <= NUM_PULLS; num++) {
            ball = bingoSet.removeRandom();
            System.out.println(ball);
        }
    }
}

class BingoBall {
    private char letter;
    private int number;

    public BingoBall (int num) {
        number = num;

        if (num <= 15)
            letter = 'B';
        else if (num <= 30)
            letter = 'I';
        else if (num <= 45)
            letter = 'N';
        else if (num <= 60)
            letter = 'G';
        else
            letter = 'O';
    }

    public String toString() {
        return (letter + " " + number);
    }
}
