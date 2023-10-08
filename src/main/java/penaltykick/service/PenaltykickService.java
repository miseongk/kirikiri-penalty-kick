package penaltykick.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import penaltykick.model.GameSetting;

public class PenaltykickService {

    public static List<Integer> makeRandomNumberList() {
        List<Integer> randomList = new ArrayList<>(GameSetting.KICK_NUMBER);
        for (int i = 0; i < GameSetting.KICK_NUMBER; i++) {
            randomList.add((int) (Math.random() * GameSetting.MAXIMUM_RANDOM_NUMBER) + 1);
        }
        return randomList;
    }


    public static String makeResultString(List<Integer> List1, List<Integer> List2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < GameSetting.KICK_NUMBER; i++) {
            if (Objects.equals(List1.get(i), List2.get(i))) {
                stringBuilder.append(GameSetting.KICK_SUCCESS);
                continue;
            }
            stringBuilder.append(GameSetting.KICK_FAILURE);
        }
        return stringBuilder.toString();
    }
}

