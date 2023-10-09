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
        validate();
        for (int i=0; i<LIMIT; i++) {
            int randomNumber = generateRandom.getNumber();
            numbers.add(randomNumber);
        }
    }

    // validate : check if goalkeeper has random numbers
    private void validate() {
        if (getSize() != 0) {
            throw new IllegalStateException("이미 골키퍼가 숫자를 생성했습니다");
        }
    }

    public int getNumber(int index) {
        if (getSize() == 0) throw new IllegalStateException("골키퍼가 아직 숫자를 생성하지 않았습니다");
        return numbers.get(index);
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public int getSize() {
        return numbers.size();
    }

}
