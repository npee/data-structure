package _05_BlackJack;

import structures.exception.ElementNotFoundException;

import java.util.Iterator;

public class BlackJack {
    Hand dealer;
    Hand player;
    Deck newDeck;

    public BlackJack(Hand dlr, Hand plr) {
        dealer = dlr;
        player = plr;
        newDeck = new Deck();
    }

    public void dealInitialCards() {
        dealer.newCard(newDeck);
        dealer.newCard(newDeck);
        player.newCard(newDeck);
        player.newCard(newDeck);
    }

    public Card hit(Hand whoHit) {
        Card result = whoHit.newCard(newDeck);

        return result;
    }

    public int handValue(Hand whoHand) {
        int result = whoHand.getHandValue();
        return result;
    }

    public void discard(Hand whoDis, Card discrd) throws ElementNotFoundException {
        Card card = null;
        boolean found = false;
        Iterator<Card> scan = whoDis.iterator();
        while (scan.hasNext() && !found) {
            card = scan.next();
            if (discrd.equals(card)) {
                whoDis.remove(card);
                found = true;
            }
        }
        if (!found) {
            throw new ElementNotFoundException("BlackJack");
        }
    }

    public boolean blackj() {
        boolean result = false;

        if (player.getHandValue() == 21) {
            result = true;
        }
        return result;
    }

    public boolean bust(Hand whoBust) {
        boolean result = false;

        if (whoBust.getHandValue() > 21) {
            result = true;
        }
        return result;
    }

    public Hand dealerPlays() {
        Hand result = dealer;

        while (dealer.getHandValue() <= 16) {
            dealer.newCard(newDeck);
        }

        return result;
    }

    public String winner() {
        String result = "";
        if (player.getHandValue() < dealer.getHandValue() && dealer.getHandValue() <= 21) {
            result = "Lose";
        } else if (player.getHandValue() == dealer.getHandValue() && dealer.getHandValue() <= 21) {
            result = "Push";
        } else {
            result = "Win";
        }

        return result;
    }
}
