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
        if (!isValidFormatAndRange(input)) throw new IllegalArgumentException("잘못된 입력형식입니다.");

        for (int i=0; i<input.length(); i+=2) {
            int number = input.charAt(i) - '0';
            this.numbers.add(number);
        }
    }

    private boolean isValidFormatAndRange(String input) {
        for (int i=0; i<input.length(); i++) {
            char token = input.charAt(i);

            if (i%2 == 0) {
                int number = token - '0';
                if (!(START <= number && number <= END)) return false;
            } else {
                if (token != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getNumber(int index) {
        if (numbers.size() == 0) throw new IllegalStateException("플레이어가 아직 숫자를 생성하지 않았습니다");
        return this.numbers.get(index);
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public String getName() {
        return this.name;
    }
}
