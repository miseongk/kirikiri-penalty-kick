package penaltykick.domain;

import penaltykick.util.GenerateRandom;

import java.util.ArrayList;

public class Goalkeeper {

    private final GenerateRandom generateRandom;
    private ArrayList<Integer> numbers;
    private final Integer LIMIT = 5;

    public Goalkeeper() {
        generateRandom = new GenerateRandom();
        numbers = new ArrayList<>();
    }

    public void generateNumbers() {
        if (isGenerated()) throw new IllegalStateException("이미 골키퍼가 숫자를 생성했습니다");

        for (int i=0; i<LIMIT; i++) {
            int randomNumber = generateRandom.getNumber();
            numbers.add(randomNumber);
        }
    }

    private boolean isGenerated() {
        if (numbers.size() != 0) {
            return true;
        }
        return false;
    }

    public int getNumber(int index) {
        if (numbers.size() == 0) throw new IllegalStateException("골키퍼가 아직 숫자를 생성하지 않았습니다");
        return numbers.get(index);
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }


}
