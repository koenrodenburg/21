package view;

import model.cards.Hand;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Bean representing a Deck
 */
public class HandBean {
    private final ArrayList<CardBean> cards = new ArrayList<>();
    private final int value;

    public HandBean(Hand hand) {
        // Convert the list of Cards to a list of CardBeans
        cards.addAll(hand.getCards().stream().map(CardBean::new).collect(Collectors.toList()));
        value = hand.getValue();
    }

    public ArrayList<CardBean> getCards() {
        return cards;
    }

    public int getValue() {
        return value;
    }
}

