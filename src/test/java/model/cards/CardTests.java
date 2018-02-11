package model.cards;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Card
 */
@RunWith(SpringRunner.class)
public class CardTests {
    private Deck deck;

    @Before
    public void setup() {
        deck = new Deck();
    }

    /**
     * Verify that the value of the card is equal to the value of the card's rank
     */
    @Test
    public void value() {
        for(Card card: deck.getCards()){
            assertThat(card.getValue()).isEqualTo(card.getRank().getValue());
        }
    }
}
