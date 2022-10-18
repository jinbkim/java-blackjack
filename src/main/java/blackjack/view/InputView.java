package blackjack.view;

import blackjack.model.PlayerBetAmounts;
import blackjack.model.PlayerNames;
import java.util.Scanner;

public class InputView {


    public PlayerNames requestPlayerName() {
        String input = requestInput(OutputView.REQUEST_PLAYER_NAME);

        try {
            return new PlayerNames(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPlayerName();
        }
    }

    public PlayerBetAmounts requestPlayerBetAmounts(PlayerNames playerNames) {
        PlayerBetAmounts playerBetAmounts = new PlayerBetAmounts();

        playerNames.getNames()
            .stream()
            .forEach(name -> playerBetAmounts.add(requestPlayerBetAmount(name)));
        return playerBetAmounts;
    }

    private int requestPlayerBetAmount(String PlayerName) {
        String input = requestInput(PlayerName + OutputView.REQUEST_BET_AMOUNT);

        return Integer.parseInt(input);
    }

    private String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
