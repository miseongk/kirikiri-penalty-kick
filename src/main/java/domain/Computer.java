package domain;

import java.util.Random;

public class Computer {
    private char[] numbers;
    private String result;
    public Computer() {
        Random random = new Random();
        StringBuffer pcNum = new StringBuffer();

        // 컴퓨터의 숫자 생성
        for (int i = 0; i < 5; i++) {
            pcNum.append(random.nextInt(3) + 1);
        }

        numbers = pcNum.toString().toCharArray();
    }

    public String getGameResult(char[] player) {
        StringBuffer result = new StringBuffer();

        for (int i=0; i<player.length; i++) {
            if (numbers[i] == player[i]) {
                result.append("O");
            }

            if (numbers[i] != player[i]) {
                result.append("X");
            }
        }

        this.result = result.toString();

        return this.result;
    }
}
