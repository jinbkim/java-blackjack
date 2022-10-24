package view;

import java.util.Scanner;
import model.PlayersName;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static PlayersName requestPlayerName() {
        OutputView.requestPlayerName();
        return new PlayersName(scanner.nextLine());
    }
}
