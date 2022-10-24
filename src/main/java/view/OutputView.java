package view;

public class OutputView {

    private static final String REQUEST_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";

    public static void requestPlayerName() {
        System.out.println(REQUEST_PLAYER_NAME);
    }
}
