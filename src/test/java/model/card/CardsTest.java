package model.card;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    void 카드_합_계산하기() {
        Cards sum9Cards = new Cards(Arrays.asList(new Card("TWO"), new Card("THREE"), new Card("FOUR")));
        Cards sum11Cards = new Cards(Arrays.asList(new Card("ACE")));
        Cards sum12Cards = new Cards(Arrays.asList(new Card("ACE"), new Card("ACE")));
        Cards sum21Cards = new Cards(Arrays.asList(new Card("ACE"), new Card("QUEEN")));
        Cards sum30Cards = new Cards(Arrays.asList(new Card("QUEEN"), new Card("QUEEN"), new Card("QUEEN")));

        Assertions.assertThat(sum9Cards.sumWithACard())
            .isEqualTo(9);
        Assertions.assertThat(sum11Cards.sumWithACard())
            .isEqualTo(11);
        Assertions.assertThat(sum12Cards.sumWithACard())
            .isEqualTo(12);
        Assertions.assertThat(sum21Cards.sumWithACard())
            .isEqualTo(21);
        Assertions.assertThat(sum30Cards.sumWithACard())
            .isEqualTo(30);
    }
}