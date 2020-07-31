package _05_BlackJack;

import javax.swing.*;

public class Card {
    protected String face;
    protected ImageIcon cardPicture;
    protected int value;
    protected String suit;

    public Card() {
        cardPicture = null;
        value = 0;
        suit = null;
        face = null;
    }

    public Card(ImageIcon x, int val, String s, String f) {
        cardPicture = x;
        value = val;
        face = f;
        suit = s;
    }

    public ImageIcon getImage() {
        return cardPicture;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int v) {
        value = v;
    }

    public String getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    @Override
    public String toString() {
        return "Face: " + face + " Suit: " + suit + " Value: " + value;
    }
}
