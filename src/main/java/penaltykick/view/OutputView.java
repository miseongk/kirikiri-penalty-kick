package penaltykick.view;

public class OutputView {

    private final static String INPUT_START = "패널티 킥 게임을 시작합니다.";
    private final static String USER_LOCATION = "총 5번의 위치를 입력해주세요.";
    private final static String GAME_RESULT = "게임 결과";
    private final static String PLAYER1 = "플레이어1 : ";
    private final static String PLAYER2 = "플레이어2 : ";
    private final static String PLAYER1_WIN = "플레이어1이(가) 우승했습니다\uD83C\uDF89";
    private final static String PLAYER2_WIN = "플레이어2이(가) 우승했습니다\uD83C\uDF89";
    private final static String DRAW = "무승부입니다.";


    public void printInputStart() {
        System.out.println(INPUT_START);
    }

    public void printUserLocation(){
        System.out.println(USER_LOCATION);
    }

    public void printPlayer1() {
        System.out.print(PLAYER1);
    }

    public void printPlayer2() {
        System.out.print(PLAYER2);
    }

    public void printGameResult(){
        System.out.println(GAME_RESULT);
    }

    public void printPlayer1Win() {
        System.out.println(PLAYER1_WIN);
    }

    public void printPlayer2Win() {
        System.out.println(PLAYER2_WIN);
    }

    public void printDraw(){
        System.out.println(DRAW);
    }


}
