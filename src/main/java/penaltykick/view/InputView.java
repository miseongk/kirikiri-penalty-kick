package penaltykick.view;

import java.util.Scanner;

class InputView {
    private static final String INPUT_NUMBER_PLAYER_1 = "플레이어1 숫자 입력";
    private static final String INPUT_NUMBER_PLAYER_2 = "플레이어2 숫자 입력";

    Scanner scanner = new Scanner(System.in);

    public String inputNumberPlayer1() {
        System.out.println(INPUT_NUMBER_PLAYER_1);
        return scanner.nextLine();
    }
    
    public String getInputNumberPlayer2() {
        System.out.println(INPUT_NUMBER_PLAYER_2);
        return scanner.nextLine();
    }
}