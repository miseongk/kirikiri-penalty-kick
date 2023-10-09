package penaltykick.domain;

import penaltykick.util.GenerateRandom;

import java.util.ArrayList;

public class Goalkeeper {

    private final GenerateRandom generateRandom;
    private ArrayList<Integer> numbers;
    private final Integer LIMIT = 5;

    public Goalkeeper(GenerateRandom gr, ArrayList<Integer> list) {
        generateRandom = gr;
        numbers = list;
    }

    public void generateNumbers() {
        checkNumbersIsNotEmpty();
        for (int i=0; i<LIMIT; i++) {
            int randomNumber = generateRandom.getNumber();
            numbers.add(randomNumber);
        }
    }


    public int getNumber(int index) {
        checkNumbersIsEmpty();
        return numbers.get(index);
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public int getSize() {
        return numbers.size();
    }

    private void checkNumbersIsNotEmpty() {
        if (getSize() != 0) {
            throw new IllegalStateException("이미 골키퍼가 숫자를 생성했습니다");
        }
    }

    private void checkNumbersIsEmpty() {
        if (getSize() == 0) {
            throw new IllegalStateException("골키퍼가 아직 숫자를 생성하지 않았습니다");
        }
    }
}
