package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 플레이어가_카드를_더받을지_정상적인_입력값() {
        Assertions.assertThatCode(() -> InputView.validateRequestDrawCard("y"))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRequestDrawCard("n"))
            .doesNotThrowAnyException();
    }

    @Test
    void 플레이어가_카드를_더받을지_비정상적인_입력값() {
        Assertions.assertThatThrownBy(() -> InputView.validateRequestDrawCard("yy"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestDrawCard("yn"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestDrawCard("nn"));
        Assertions.assertThatThrownBy(() -> InputView.validateRequestDrawCard("abc"));
    }

}