package penaltykick.view;

public class OutputView {
    private static final String PRINT_START_GAME = "패널티 킥 게임을 시작합니다.";
    private static final String PRINT_INPUT_FIVE_NUMBER = "총 5번의 위치를 입력해주세요.";

    public void printStartGame() {
        System.out.println(PRINT_START_GAME);
    }

    public void printInputFiveNumber() {
        System.out.println(PRINT_INPUT_FIVE_NUMBER);
    }
}
