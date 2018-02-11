package model.cards;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for the Rank enum
 */
@RunWith(SpringRunner.class)
public class RankTests {
    /**
     * Verify that all Ranks have a value between 1 and 11
     */
    @Test
    public void valueRange() {
        for(Rank rank: Rank.values()) {
            assertThat(rank.getValue()).isBetween(1, 11);
        }
    }
}
