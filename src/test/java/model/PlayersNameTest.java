package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayersNameTest {

    @Test
    void 플레이어_이름_입력값_파싱하기() {
        PlayersName playersName = new PlayersName(" a,bc , d e f, ghij");

        Assertions.assertThat(playersName.get())
            .contains("a", "bc", "def", "ghij");
    }
}