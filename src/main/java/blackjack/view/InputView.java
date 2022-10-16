package blackjack.view;

import blackjack.model.Players;
import java.util.Scanner;

public class InputView {

    public String requestPlayer() {
        String input = requestInput(OutputView.REQUEST_PLAYER);
        Players Players = new Players(input);

        return input;
    }

    public String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
