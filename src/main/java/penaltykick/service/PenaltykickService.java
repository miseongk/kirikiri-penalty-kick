package penaltykick.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import penaltykick.model.Game;

public class PenaltykickService {

    public static List<Integer> makeRandomNumberList() {
        List<Integer> randomList = new ArrayList<>(Game.KICK_NUMBER);
        for (int i = 0; i < Game.KICK_NUMBER; i++) {
            randomList.add((int) (Math.random() * Game.MAXIMUM_RANDOM_NUMBER) + 1);
        }
        return randomList;
    }


    public static String makeResultString(List<Integer> List1, List<Integer> List2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Game.KICK_NUMBER; i++) {
            if (Objects.equals(List1.get(i), List2.get(i))) {
                stringBuilder.append(Game.KICK_SUCCESS);
                continue;
            }
            stringBuilder.append(Game.KICK_FAILURE);
        }
        return stringBuilder.toString();
    }
}

