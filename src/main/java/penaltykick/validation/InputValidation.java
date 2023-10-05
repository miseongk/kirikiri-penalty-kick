package penaltykick.validation;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class InputValidation {
    private static final String ERROR = "[ERROR] ";
    private static final String NOT_FIVE_VALUE = "5개의 값을 공백으로 구분해 입력해주세요.";
    private static final String NOT_NUMBER = "숫자를 입력해주세요.";
    private static final String NOT_BETWEEN_ONE_AND_THREE = "1~3 사이의 숫자를 입력해주세요.";
    public static List<Integer> validateInputValue(String input) {
        List<Integer> inputNumber = validateContainsFiveValue(input);
        validateBetweenOneAndThree(inputNumber);
        return inputNumber;
    }

    private static List<Integer> validateContainsFiveValue(String input) {
        String[] stringArr = input.split(" ");
        if(stringArr.length != 5) {
            throw new IllegalArgumentException(ERROR + NOT_FIVE_VALUE);
        }
        return validateIsNumber(stringArr);
    }

    private static List<Integer> validateIsNumber(String[] stringArr) {
        List<Integer> inputNumber = new ArrayList<>();
        try {
            for(String s: stringArr) {
                inputNumber.add(Integer.parseInt(s));
            }
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_NUMBER);
        }
        return inputNumber;
    }

    private static void validateBetweenOneAndThree(List<Integer> inputNumber) {
        for(int i: inputNumber) {
            if(i < 1 || 3 < i) {
                throw new IllegalArgumentException(ERROR + NOT_BETWEEN_ONE_AND_THREE);
            }
        }
    }
}
