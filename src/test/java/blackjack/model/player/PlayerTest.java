package blackjack.model.player;


import blackjack.model.card.CardCollection;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 게임시작시_플레이어_각각_카드_2장씩_뽑기() {
        Assertions.assertThat(CardCollection.getCards()
                .size())
            .isEqualTo(52);
        Players players = new Players(Arrays.asList("1번", "2번", "3번"), Arrays.asList(0, 0, 0));
        Assertions.assertThat(CardCollection.getCards()
                .size())
            .isEqualTo(46);
    }

}