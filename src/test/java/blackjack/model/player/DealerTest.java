package blackjack.model.player;

import blackjack.model.card.CardCollection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DealerTest {

    @Test
    void 게임시작시_딜러가_카드_2장_뽑기() {
        Assertions.assertThat(CardCollection.getCards()
                .size())
            .isEqualTo(52);
        Dealer dealer = new Dealer();
        Assertions.assertThat(CardCollection.getCards()
                .size())
            .isEqualTo(50);
    }
}