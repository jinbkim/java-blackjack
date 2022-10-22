package blackjack.model.card;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    void 카드_숫자_합계_계산하기() {
        Cards cards = new Cards(0);
        List<Card> cardList = cards.get();

        cardList.add(new Card(CardLetter.ACE, CardShape.CLOVER));
        Assertions.assertThat(cards.calculateSumWithACard())
            .isEqualTo(11);

        cards.add(new Card(CardLetter.NINE, CardShape.CLOVER));
        Assertions.assertThat(cards.calculateSumWithACard())
            .isEqualTo(20);

        cardList.add(new Card(CardLetter.ACE, CardShape.CLOVER));
        Assertions.assertThat(cards.calculateSumWithACard())
            .isEqualTo(21);

        cardList.add(new Card(CardLetter.ACE, CardShape.CLOVER));
        Assertions.assertThat(cards.calculateSumWithACard())
            .isEqualTo(12);
    }
}