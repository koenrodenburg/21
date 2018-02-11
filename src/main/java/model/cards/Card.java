package model.cards;

/**
 * Class representing a playing card
 */
public class Card {
    private Suit suit;
    private Rank rank;

    /**
     * Creates a card with the specified suit and rank
     * @param suit Suit suit of the card
     * @param rank Rank rank of the card
     */
    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Get the Suit of the Card
     * @return Suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Get the Rank of the Card
     * @return Rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Gets the value of the card
     * @return value of the card
     */
    int getValue() {
        return rank.getValue();
    }

    /**
     * Equals implementation
     * @param o Other object
     * @return boolean Whether the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return suit == card.suit && rank == card.rank;

    }

    /**
     * Hashcode implementation
     * @return int Hashcode of the card
     */
    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }

    /**
     * ToString implementation
     * @return String representation of the card
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
