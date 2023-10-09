package penaltykick.domain;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final Integer START = 1;
    private final Integer END = 3;
    private ArrayList<Integer> numbers;

    public Player(String playerName) {
        name = playerName;
        numbers = new ArrayList<>();
    }

    public void generateNumbers(String input) {
        checkNumbersIsNotEmpty();
        checkValidInput(input);

        for (int i=0; i<input.length(); i+=2) {
            int number = input.charAt(i) - '0';
            this.numbers.add(number);
        }
    }


    public int getNumber(int index) {
        checkNumbersIsEmpty();
        return this.numbers.get(index);
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return numbers.size();
    }

    private void checkValidInput(String input) {
        for (int i=0; i<input.length(); i++) {
            char token = input.charAt(i);
            checkValidToken(i, token);
        }
    }

    private void checkValidToken(Integer idx, Character token) {
        if (idx%2 == 0) {
            checkValidNumber(token);
        } else {
            checkValidSpace(token);
        }
    }

    private void checkValidNumber(Character token) {
        Integer number = token - '0';
        if (!(START <= number && number <= END)) {
            throw new IllegalArgumentException("잘못된 입력형식입니다.");
        }
    }

    private void checkValidSpace(Character token) {
        if (token != ' ') {
            throw new IllegalArgumentException("잘못된 입력형식입니다.");
        }
    }

    private void checkNumbersIsNotEmpty() {
        if (getSize() != 0) {
            throw new IllegalStateException("이미 플레이어가 숫자를 생성했습니다");
        }
    }

    private void checkNumbersIsEmpty() {
        if (getSize() == 0) {
            throw new IllegalStateException("플레이어가 아직 숫자를 생성하지 않았습니다")
        }
    }
}
