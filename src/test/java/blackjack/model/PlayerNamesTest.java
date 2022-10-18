package blackjack.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerNamesTest {

    @Test
    void 플레이어_이름_파싱하기() {
        PlayerNames playerNames = new PlayerNames(" 가 , 나 다, 라마 바, 사 아자차 ");
        List<String> names = Arrays.asList("가", "나다", "라마바", "사아자차");

        for (String name : playerNames.getNames()) {
            Assertions.assertThat(names.contains(name))
                .isTrue();
        }
    }

    @Test
    void 플레이어_이름의_정상적인_입력() {
        Assertions.assertThatCode(() -> new PlayerNames(" 가 , 나 다, 라마 바, 사 아자차 "))
            .doesNotThrowAnyException();
    }

    @Test
    void 플레이어_이름의_비정상적인_입력() {
        Assertions.assertThatThrownBy(() -> new PlayerNames(" 가 ,, 나 다, 라마 바, 사 아자차 "));
    }
}