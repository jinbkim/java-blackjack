package blackjack.view;

import blackjack.model.PlayerNames;
import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> requestPlayersBetAmount(List<String> playersName) {
        List<Integer> playersBetAmount = new ArrayList<>();

        for (String playerName : playersName) {
            int betAmount = requestPlayerBetAmount(playerName);
            playersBetAmount.add(betAmount);
        }
        return playersBetAmount;
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
