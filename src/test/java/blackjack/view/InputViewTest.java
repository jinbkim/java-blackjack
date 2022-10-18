package blackjack.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView = new InputView();

    @Test
    void 배팅_금액_정상적인_입력() {
        Assertions.assertThatCode(() -> inputView.validateBetAmount("1"))
            .doesNotThrowAnyException();
    }

    @Test
    void 배팅_금액_비정상적인_입력() {
        Assertions.assertThatThrownBy(() -> inputView.validateBetAmount("a"));
        Assertions.assertThatThrownBy(() -> inputView.validateBetAmount("1b"));
        Assertions.assertThatThrownBy(() -> inputView.validateBetAmount("-3"));
        Assertions.assertThatThrownBy(() -> inputView.validateBetAmount("0"));
    }
}