package penaltykick.model;

import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Integer> randomList;

    public Game(List<Integer> randomList) {
        this.randomList = Collections.unmodifiableList(randomList);
    }

    public String makeResultString(List<Integer> List) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < GameSetting.KICK_NUMBER; i++) {
            stringBuilder.append(getResultCharacter(randomList.get(i), List.get(i)));
        }
        return stringBuilder.toString();
    }

    private String getResultCharacter(int i, int j) {
        if (i == j) {
            return GameSetting.KICK_SUCCESS;
        }
        return GameSetting.KICK_FAILURE;
    }
}
