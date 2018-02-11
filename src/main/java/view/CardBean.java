package view;

import model.cards.Card;

/**
 * Bean representing a Card
 */
public class CardBean {
    private final String suit;
    private final String rank;
    private final String string;

    public CardBean(Card card) {
        suit = card.getSuit().toString();
        rank = card.getRank().toString();
        string = card.toString();
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public String getString() {
        return string;
    }
}
