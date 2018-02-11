package model.cards;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Hand
 */
@RunWith(SpringRunner.class)
public class HandTests {
    private Hand hand;

    @Before
    public void setup() {
        hand = new Hand();
    }

    /**
     * Assert that the number of cards increases when adding cards to the hand
     */
    @Test
    public void numberOfCards() {
        assertThat(hand.getNumberOfCards()).isEqualTo(0);

        hand.giveCard(new Card(Suit.DIAMONDS, Rank.EIGHT));
        assertThat(hand.getNumberOfCards()).isEqualTo(1);

        hand.giveCard(new Card(Suit.DIAMONDS, Rank.SIX));
        hand.giveCard(new Card(Suit.DIAMONDS, Rank.ACE));
        assertThat(hand.getNumberOfCards()).isEqualTo(3);
    }

    /**
     * Assert that the value of the hand is calculated correctly
     */
    @Test
    public void value() {
        hand.giveCard(new Card(Suit.CLUBS, Rank.TWO));
        assertThat(hand.getValue()).isEqualTo(hand.getCards().stream().mapToInt(Card::getValue).sum());

        hand.giveCard(new Card(Suit.DIAMONDS, Rank.JACK));
        assertThat(hand.getValue()).isEqualTo(hand.getCards().stream().mapToInt(Card::getValue).sum());

        hand.giveCard(new Card(Suit.HEARTS, Rank.ACE));
        assertThat(hand.getValue()).isEqualTo(hand.getCards().stream().mapToInt(Card::getValue).sum());
    }
}
