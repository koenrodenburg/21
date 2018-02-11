package model.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class representing a deck of playing cards
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    /**
     * Constructor. Creates an unshuffled deck of cards
     */
    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Get the cards of this deck
     * TODO return an UnmodifiableList representation so an external class cannot change the cards in the deck
     * @return ArrayList The cards in this deck
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Shuffle the deck
     */
    public Deck shuffle() {
        Collections.shuffle(cards);
        return this;
    }

    /**
     * Gets and removes the next card from the deck
     * @return Card the next card from the deck
     */
    public Card deal() {
        if(!hasRemainingCards()) {
            throw new UnsupportedOperationException("There are no cards left in the deck");
        }
        return cards.remove(0);
    }

    /**
     * @return The number of remaining cards in the deck
     */
    int getNumberOfRemainingCards() {
        return cards.size();
    }

    /**
     * @return Whether any cards are remaining in the deck
     */
    private boolean hasRemainingCards() {
        return getNumberOfRemainingCards() > 0;
    }

    /**
     * Equals implementation
     * @param o Object to compare with
     * @return Whether the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deck deck = (Deck) o;

        return cards.equals(deck.cards);

    }

    /**
     * Hashcode implementation
     * @return int hashcode of this deck
     */
    @Override
    public int hashCode() {
        return cards.hashCode();
    }

    /**

     * ToString implementation
     * @return String representation of the deck
     */
    @Override
    public String toString() {
        return cards.toString();
    }
}