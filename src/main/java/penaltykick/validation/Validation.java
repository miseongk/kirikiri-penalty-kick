package penaltykick.validation;

import java.util.ArrayList;

public class Validation {
    public static final int PLAY_TIMES = 5;

    public static void numericValidation(ArrayList<String> numberList) {

        for (String a : numberList) {
            try {
                Integer.parseInt(a);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                System.exit(1);
            }
        }
    }

    public static void lengthValidation(ArrayList<String> numberList) {
        if( numberList.size() != PLAY_TIMES ){
            System.out.println("[ERROR] 길이에 맞게 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void numericRangeValidation(ArrayList<String> numberList) {
        for (String a : numberList) {
            if (0 > Integer.parseInt(a) || Integer.parseInt(a) > 4) {
                System.out.println("[ERROR] 범위에 맞게 입력해 주세요.");
                throw new IllegalArgumentException();
            }
        }
    }
}
