package validator;

public class Validator {
    public static void validate(String player) {
        if ("".equals(player)) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
        if (!player.replaceAll(" ", "").matches("^[0-9]*$")) {
            throw new IllegalArgumentException("공백으로 구분해서 입력해야 합니다.");
        }

        String[] numbers = player.split(" ");

        if (numbers.length != 5) {
            throw new IllegalArgumentException("5개의 값을 입력해야 합니다.");
        }

        for (String number : numbers) {
            if (Integer.valueOf(number) < 1 || Integer.valueOf(number) > 3) {
                throw new IllegalArgumentException("1-3 사이의 값만 입력할 수 있습니다.");
            }
        }
    }
}

