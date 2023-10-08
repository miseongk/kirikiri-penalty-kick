package penaltykick.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PenaltykickService {

    private static final int KICK_NUMBER = 5;
    private static final int MAXIMUM_RANDOM_NUMBER = 3;
    private static final String KICK_SUCCESS = "O";
    private static final String KICK_FAILURE = "X";

    public static List<Integer> makeRandomNumberList() {
        List<Integer> randomList = new ArrayList<>(KICK_NUMBER);
        for (int i = 0; i < KICK_NUMBER; i++) {
            randomList.add((int) (Math.random() * MAXIMUM_RANDOM_NUMBER) + 1);
        }
        return randomList;
    }

    public static String makeResultString(List<Integer> List1, List<Integer> List2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < KICK_NUMBER; i++) {
            if (Objects.equals(List1.get(i), List2.get(i))) {
                stringBuilder.append(KICK_SUCCESS);
                continue;
            }
            stringBuilder.append(KICK_FAILURE);
        }
        return stringBuilder.toString();
    }
}

