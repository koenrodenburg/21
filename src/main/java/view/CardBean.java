package view;

import model.cards.Card;

/**
 * Bean representing a Card
 */
public class CardBean {
    private final String suit;
    private final String rank;

    public CardBean(Card card) {
        suit = card.getSuit().toString();
        rank = card.getRank().toString();
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}
