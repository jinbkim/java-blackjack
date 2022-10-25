package model.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayersBetMoneyTest {

    @Test
    void 베팅금액_정상적인_입력값() {
        PlayersBetMoney playersBetMoney = new PlayersBetMoney();
        Assertions.assertThatCode(() -> playersBetMoney.add(" 123 "))
            .doesNotThrowAnyException();
    }

    @Test
    void 베팅금액_비정상적인_입력값() {
        PlayersBetMoney playersBetMoney = new PlayersBetMoney();
        Assertions.assertThatThrownBy(() -> playersBetMoney.add("a"));
        Assertions.assertThatThrownBy(() -> playersBetMoney.add("a12"));
        Assertions.assertThatThrownBy(() -> playersBetMoney.add("0"));
        Assertions.assertThatThrownBy(() -> playersBetMoney.add("00"));
    }
}