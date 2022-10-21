package blackjack.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 배팅_금액_정상적인_입력() {
        Assertions.assertThatCode(() -> InputView.validateBetAmount("1"))
            .doesNotThrowAnyException();
    }

    @Test
    void 배팅_금액_비정상적인_입력() {
        Assertions.assertThatThrownBy(() -> InputView.validateBetAmount("a"));
        Assertions.assertThatThrownBy(() -> InputView.validateBetAmount("1b"));
        Assertions.assertThatThrownBy(() -> InputView.validateBetAmount("-3"));
        Assertions.assertThatThrownBy(() -> InputView.validateBetAmount("0"));
    }

    @Test
    void 카드를_더받을지에_대한_정상적인_입력() {
        Assertions.assertThatCode(() -> InputView.validateIsDrawCard("y")).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateIsDrawCard("n")).doesNotThrowAnyException();
    }

    @Test
    void 카드를_더받을지에_대한_비정상적인_입력() {
        Assertions.assertThatThrownBy(() -> InputView.validateIsDrawCard("a"));
        Assertions.assertThatThrownBy(() -> InputView.validateIsDrawCard("yy"));
        Assertions.assertThatThrownBy(() -> InputView.validateIsDrawCard("nn"));
        Assertions.assertThatThrownBy(() -> InputView.validateIsDrawCard("yn"));

    }
}