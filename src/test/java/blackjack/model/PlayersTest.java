package blackjack.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    void 플레이어_이름_파싱하기() {
        Players players = new Players(" 가 , 나 다, 라마 바, 사 아자차 ");
        List<String> names = Arrays.asList("가", "나다", "라마바", "사아자차");

        for (Player player : players.getPlayers()) {
            Assertions.assertThat(names.contains(player.getName()))
                .isTrue();
        }
    }

    @Test
    void 플레이어_이름의_비정상적인_입력받기() {
        Assertions.assertThatThrownBy(() -> new Players(" 가 ,, 나 다, 라마 바, 사 아자차 "));
    }
}