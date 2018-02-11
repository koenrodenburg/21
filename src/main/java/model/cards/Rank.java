package model.cards;

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

    /**
     * Constructor
     * @param name String Name of the Rank
     * @param value int Value of the Rank
     */
    Rank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Get the value of this Rank
     * @return int Value of this Rank
     */
    public int getValue() {
        return value;
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
