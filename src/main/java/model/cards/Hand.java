package model.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * A Hand of cards
 */
public class Hand {
    private final List<Card> cards = new ArrayList<>();
    private int value = 0;

    /**
     * Add a card to this Hand
     * @param card Card The Card to add
     */
    public void giveCard(Card card) {
        cards.add(card);
        calcValue();
    }

    /**
     * Get the number of cards currently held
     * @return int Number of cards in this Hand
     */
    public int getNumberOfCards() {
        return cards.size();
    }

    /**
     * Get the cards in this Hand
     * TODO return an UnmodifiableList representation so an external class cannot change the cards in the hand
     * @return
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Get the total value of this Hand
     * @return Total value of this Hand
     */
    public int getValue() {
        return value;
    }

    /**
     * Calculates the current value of the Hand
     * TODO consider the fact that an Ace can be 1 or 11 points
     */
    private void calcValue() {
        value = cards.stream().mapToInt(Card::getValue).sum();
    }
}
