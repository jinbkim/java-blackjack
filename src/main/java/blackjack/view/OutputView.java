package blackjack.view;

import blackjack.model.player.Dealer;
import blackjack.model.player.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String REQUEST_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String WRONG_PLAYER_NAME = "잘못된 이름 입력값 입니다.";
    private static final String REQUEST_BET_AMOUNT = "의 배팅 금액은?";
    private static final String WRONG_BET_AMOUNT = "잘못된 배팅 금액 입니다.";
    private static final String[] INITIAL_CARD_DISTRIBUTION = {"딜러와 ", "에게 2장의 카드를 나누었습니다."};
    private static final String DEALER = "딜러";
    private static final String CARD_STATE = "카드: ";

    private static final String PLAYER_NAME_JOIN_DEL = ", ";
    private static final String NEWLINE = "\n";

    public static void printWrongPlayerName() {
        System.out.println(WRONG_PLAYER_NAME);
    }

    public static void printWrongBetAmount() {
        System.out.println(WRONG_BET_AMOUNT);
    }

    public static void printRequestPlayerName() {
        System.out.println(REQUEST_PLAYER_NAME);
    }

    public static void printRequestPlayerBetAmount(String playerName) {
        System.out.println(NEWLINE + playerName + REQUEST_BET_AMOUNT);
    }

    public static void printInitialCardDistribution(List<Player> players, Dealer dealer) {
        String playerNames = players.stream()
            .map(player -> player.getName())
            .collect(Collectors.joining(PLAYER_NAME_JOIN_DEL));

        System.out.println(NEWLINE + INITIAL_CARD_DISTRIBUTION[0] + playerNames + INITIAL_CARD_DISTRIBUTION[1]);
        printDealerCards(dealer);
        printPlayersCards(players);
    }

    public static void printDealerCards(Dealer dealer) {
        System.out.println(DEALER + CARD_STATE + dealer.getCards()
            .toString());
    }

    public static void printPlayersCards(List<Player> players) {
        players.forEach(player -> {
            printPlayerCards(player);
            System.out.println();
        });
    }

    public static void printPlayerCards(Player player) {
        System.out.print(player.getName() + CARD_STATE + player.getCards());
    }
}
