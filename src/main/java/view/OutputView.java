package view;

import java.util.List;
import java.util.stream.Collectors;
import model.player.Dealer;
import model.player.Player;

public class OutputView {

    private static final String REQUEST_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String WRONG_PLAYER_NAME = "잘못된 플레이어 이름 입니다.";
    private static final String REQUEST_PLAYER_BET_MONEY = "의 배팅 금액은?";
    private static final String WRONG_PLAYER_BET_MONEY = "0 보다 큰 숫자만 입력하세요.";
    private static final String[] DRAW_TWO_CARDS = {"딜러와 ", "에게 2장의 나누었습니다."};
    private static final String DEALER = "딜러";
    private static final String CARD_LIST = "카드: ";
    private static final String PLAYER_NAME_JOIN_DELIMITER = ", ";
    private static final String REQUEST_DRAW_CARD = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String WRONG_REQUEST_DRAW_CARD = "y 또는 n만 입력하세요.";

    public static void printRequestPlayerName() {
        System.out.println(REQUEST_PLAYER_NAME);
    }

    public static void printWrongPlayerName() {
        System.out.println(WRONG_PLAYER_NAME);
    }

    public static void printRequestPlayerBetMoney(String name) {
        System.out.println(name + REQUEST_PLAYER_BET_MONEY);
    }

    public static void printWrongPlayerBetMoney() {
        System.out.println(WRONG_PLAYER_BET_MONEY);
    }

    public static void printInitialCardDraw(List<Player> players, Dealer dealer) {
        String names = players.stream()
            .map(player -> player.getName())
            .collect(Collectors.joining(PLAYER_NAME_JOIN_DELIMITER));

        System.out.println(DRAW_TWO_CARDS[0] + names + DRAW_TWO_CARDS[1]);
        System.out.println(DEALER + CARD_LIST + dealer.getCardOne());
        players.stream()
            .forEach(OutputView::printPlayerCard);
    }

    public static void printRequestDrawCard(String name) {
        System.out.println(name + REQUEST_DRAW_CARD);
    }

    public static void printWrongRequestDrawCard() {
        System.out.println(WRONG_REQUEST_DRAW_CARD);
    }

    public static void printPlayerCard(Player player) {
        System.out.println(player.getName() + CARD_LIST + player.getCards());
    }
}
