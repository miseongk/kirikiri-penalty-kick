package penaltykick.model;

import java.util.*;
public class Player {
    private final List<Integer> numberList;
    private String resultString;
    private int successNumber;
    public Player(List<Integer> numberList) {
        this.numberList = numberList;
        this.successNumber = 0;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void initResultValue(String resultString) {
        this.resultString = resultString;
        for(char c: resultString.toCharArray()) {
            if(c == 'O') successNumber++;
        }
    }

      public String getResultString() {
        return resultString;
    }

    public int getSuccessNumber() {
        return successNumber;
    }
}
