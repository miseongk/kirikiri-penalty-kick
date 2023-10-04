package domain;

public class Player {
    private char[] numbers;
    public Player(String input) {
        numbers = parse(input);
    }

    private char[] parse(String inputs) {
        return inputs.replaceAll(" ", "").toCharArray();
    }

    public char[] getNumbers() {
        return numbers;
    }
}
