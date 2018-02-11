package model.cards;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Deck
 */
@RunWith(SpringRunner.class)
public class DeckTests {
    private Deck deck;

    @Before
    public void setup() {
        deck = new Deck().shuffle();
    }

    @Test
    public void numberOfCards() {
        assertThat(deck.getNumberOfRemainingCards()).isEqualTo(52);
    }

    @Test
    public void shuffle() {
        Deck unshuffledDeck = new Deck();
        assertThat(deck).isNotEqualTo(unshuffledDeck);
    }

    @Test
    public void dealCards() {
        Card card = deck.deal();
        assertThat(card).isNotNull();
        assertThat(deck.getNumberOfRemainingCards()).isEqualTo(51);
        deck.deal();
        deck.deal();
        assertThat(deck.getNumberOfRemainingCards()).isEqualTo(49);
    }
}
