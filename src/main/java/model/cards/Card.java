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

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    /**
     * Gets the value of the card
     * @return value of the card
     */
    public int getValue() {
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

    /**
     * Enumeration of suits as used in playing cards
     */
    public enum Suit {
        HEARTS("Hearts"),
        SPADES("Spades"),
        DIAMONDS("Diamonds"),
        CLUBS("Clubs");

        private final String name;

        Suit(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Enumeration of ranks as used in playing cards
     */
    public enum Rank {
        ACE("Ace", 1),
        TWO("Two", 2),
        THREE("Three", 3),
        FOUR("Four", 4),
        FIVE("Five", 5),
        SIX("Six", 6),
        SEVEN("Seven", 7),
        EIGHT("Eight", 8),
        NINE("Nine", 9),
        TEN("Ten", 10),
        JACK("Jack", 1),
        QUEEN("Queen", 2),
        KING("King", 3);

        private final String name;
        private final int value;

        Rank(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
