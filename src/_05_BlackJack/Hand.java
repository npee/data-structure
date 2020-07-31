package _05_BlackJack;

import structures.ArraySet;
import structures.exception.ElementNotFoundException;

import java.util.Iterator;

public class Hand {
    protected ArraySet<Card> inHand;
    protected int handValue, count;

    public Hand() {
        inHand = new ArraySet<>(12);
        handValue = 0;
        count = 0;
    }

    private void reduceHand(Card newCard) {
        if (handValue > 21 && aceInHand())
            handValue -= 10;
    }

    private boolean aceInHand() {
        boolean result = false;
        Card cardChk = null;
        Iterator<Card> scan = inHand.iterator();

        while (scan.hasNext()) {
            cardChk = scan.next();
            if (cardChk.getValue() == 11) {
                cardChk.setValue(1);
                result = true;
            }
        }
        return result;
    }

    public Card newCard(Deck currentDeck) {
        Card result;
        result = currentDeck.getCard();
        inHand.add(result);
        handValue += result.getValue();
        reduceHand(result);

        return result;
    }

    public int getHandValue() {
        return handValue;
    }

    public Iterator<Card> iterator() {
        return inHand.iterator();
    }

    public Card remove(Card crd) throws ElementNotFoundException {
        return (inHand.remove(crd));
    }

    public String toString() {
        String result = "";
        Card cardStr = null;
        int i = 0;
        Iterator<Card> scan = inHand.iterator();
        while (scan.hasNext()) {
            cardStr = scan.next();
            result += "card " + i + ": " + cardStr.getValue() + "\n";
            i++;
        }

        return result;
    }

}
