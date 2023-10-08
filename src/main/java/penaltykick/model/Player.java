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
        return Collections.unmodifiableList(numberList);
    }

    public void initResultValue(String resultString) {
        this.resultString = resultString;
        for (char c : resultString.toCharArray()) {
            isSuccess(c);
        }
    }

    public void isSuccess(char c) {
        if (GameSetting.KICK_SUCCESS.equals(String.valueOf(c))) {
            successNumber++;
        }
    }


    public String getResultString() {
        return resultString;
    }

    public int getSuccessNumber() {
        return successNumber;
    }
}
