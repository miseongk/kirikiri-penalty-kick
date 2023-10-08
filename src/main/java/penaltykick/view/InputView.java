package penaltykick.view;

import penaltykick.validation.InputValidation;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_NUMBER_PLAYER_1 = "플레이어1 : ";
    private static final String INPUT_NUMBER_PLAYER_2 = "플레이어2 : ";

    Scanner scanner = new Scanner(System.in);

    public List<Integer> inputNumberPlayer1() {
        System.out.print(INPUT_NUMBER_PLAYER_1);
        return InputValidation.validateInputValue(scanner.nextLine());
    }

    public List<Integer> inputNumberPlayer2() {
        System.out.print(INPUT_NUMBER_PLAYER_2);
        return InputValidation.validateInputValue(scanner.nextLine());
    }
}