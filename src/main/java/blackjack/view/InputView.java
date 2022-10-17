package blackjack.view;

import blackjack.model.Players;
import java.util.Scanner;

public class InputView {

    public Players requestPlayer() {
        String input = requestInput(OutputView.REQUEST_PLAYER);
        try {
            return new Players(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPlayer();
        }
    }

    public String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
