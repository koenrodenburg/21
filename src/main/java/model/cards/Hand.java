package model.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * A Hand of cards
 */
public class Hand {
    private final List<Card> cards = new ArrayList<>();
    private int value = 0;

    public void giveCard(Card card) {
        cards.add(card);
        calcValue();
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getValue() {
        return value;
    }

    private void calcValue() {
        value = cards.stream().mapToInt(Card::getValue).sum();
    }
}
