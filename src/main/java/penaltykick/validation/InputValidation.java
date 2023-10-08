package penaltykick.validation;

import java.util.ArrayList;
import java.util.List;
import penaltykick.model.Game;

public class InputValidation {

    private static final String ERROR = "[ERROR] ";
    private static final String NOT_FIVE_VALUE = "5개의 값을 공백으로 구분해 입력해주세요.";
    private static final String NOT_NUMBER = "숫자를 입력해주세요.";
    private static final String NOT_BETWEEN_ONE_AND_THREE =
        Game.START_SELECT_NUMBER + "~ " + Game.END_SELECT_NUMBER + "사이의 숫자를 입력해주세요.";

    public static List<Integer> validateInputValue(String input) {
        List<Integer> inputNumber = validateContainsFiveValue(input);
        validateBetweenOneAndThree(inputNumber);
        return inputNumber;
    }

    private static List<Integer> validateContainsFiveValue(String input) {
        String[] stringArr = input.split(Game.INPUT_STRING_DIVIDE_CHARACTER);
        if (stringArr.length != Game.KICK_NUMBER) {
            throw new IllegalArgumentException(ERROR + NOT_FIVE_VALUE);
        }
        return validateIsNumber(stringArr);
    }

    private static List<Integer> validateIsNumber(String[] stringArr) {
        List<Integer> inputNumber = new ArrayList<>();
        try {
            checkIsNumber(stringArr, inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_NUMBER);
        }
        return inputNumber;
    }

    private static void checkIsNumber(String[] stringArr, List<Integer> inputNumber) {
        for (String s : stringArr) {
            inputNumber.add(Integer.parseInt(s));
        }
    }

    private static void validateBetweenOneAndThree(List<Integer> inputNumber) {
        for (int i : inputNumber) {
            isBetweenOneAndThree(i);
        }
    }

    private static void isBetweenOneAndThree(int i) {
        if(i < Game.START_SELECT_NUMBER || Game.END_SELECT_NUMBER < i) {
            throw new IllegalArgumentException(ERROR + NOT_BETWEEN_ONE_AND_THREE);
        }
    }
}

