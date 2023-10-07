package penaltykick.domain;

import java.util.ArrayList;
import java.util.List;

public class GoalKeeper {

    private List<Integer> defensePosition = new ArrayList<>();

    public GoalKeeper() {
        int position;

        for (int i = 0; i < 5; i++) {
            position = (int) (Math.random() * 3) + 1;
            defensePosition.add(position);
        }
    }

    public List<Integer> getDefensePosition() {
        return defensePosition;
    }
}
