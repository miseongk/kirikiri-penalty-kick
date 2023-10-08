package penaltykick.utils;

import penaltykick.validation.Validation;

import java.util.ArrayList;

public class Util {
    public static ArrayList<Integer> stringToIntegerArrayList(ArrayList<String> inputNumber){

        Validation.numericValidation(inputNumber);
        Validation.lengthValidation(inputNumber);
        Validation.numericRangeValidation(inputNumber);

        ArrayList<Integer> lst = new ArrayList<>();

        for (String num : inputNumber) {
            lst.add(Integer.parseInt(num));
        }

        return lst;
    }
}
