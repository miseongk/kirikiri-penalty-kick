package penaltykick.view;

public class OutputView {

    private static final String PRINT_START_GAME = "패널티 킥 게임을 시작합니다.";
    private static final String PRINT_INPUT_FIVE_NUMBER = "총 5번의 위치를 입력해주세요.";
    private static final String PRINT_GAME_RESULT = "\n게임 결과";
    private static final String PRINT_PLAYER_1_RESULT = "플레이어1 : ";
    private static final String PRINT_PLAYER_2_RESULT = "플레이어2 : ";
    private static final String PRINT_RESULT_PLAYER_1_WIN = "플레이어1이(가) 우승했습니다\uD83C\uDF89";
    private static final String PRINT_RESULT_PLAYER_2_WIN = "플레이어2이(가) 우승했습니다\uD83C\uDF89";
    private static final String PRINT_RESULT_DRAW = "무승부입니다.";

    public void printStartGame() {
        System.out.println(PRINT_START_GAME);
    }

    public void printInputFiveNumber() {
        System.out.println(PRINT_INPUT_FIVE_NUMBER);
    }

    public void printGameResult() {
        System.out.println(PRINT_GAME_RESULT);
    }

    public void printPlayer1Result(String result) {
        System.out.println(PRINT_PLAYER_1_RESULT + result);
    }

    public void printPlayer2Result(String result) {
        System.out.println(PRINT_PLAYER_2_RESULT + result);
    }

    public void printResultPlayer1Win() {
        System.out.println(PRINT_RESULT_PLAYER_1_WIN);
    }

    public void printResultPlayer2Win() {
        System.out.println(PRINT_RESULT_PLAYER_2_WIN);
    }

    public void printResultDraw() {
        System.out.println(PRINT_RESULT_DRAW);
    }
}
