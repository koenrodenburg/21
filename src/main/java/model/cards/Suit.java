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

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
