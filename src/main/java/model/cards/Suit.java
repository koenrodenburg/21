package model.cards;

/**
 * Enumeration of suits as used in playing cards
 */
public enum Suit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String name;

    /**
     * Constructor
     * @param name String Name of the Suit
     */
    Suit(String name) {
        this.name = name;
    }

    /**
     * ToString implementation
     * @return String
     */
    @Override
    public String toString() {
        return name;
    }
}
