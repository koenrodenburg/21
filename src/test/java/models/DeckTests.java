package models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test c;ass for Deck
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Deck.class)
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
        Card card = deck.getNextCard();
        assertThat(card).isNotNull();
        assertThat(deck.getNumberOfRemainingCards()).isEqualTo(51);
        deck.getNextCard();
        deck.getNextCard();
        assertThat(deck.getNumberOfRemainingCards()).isEqualTo(49);
    }
}
