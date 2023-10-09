package penaltykick.dto;

import penaltykick.domain.Player;

public class PlayerResult {
    private final String name;
    private final String state;

    private final Integer goal;

    public PlayerResult(String playerName, String playerState, Integer numberOfGoal) {
        name = playerName;
        state = playerState;
        goal = numberOfGoal;
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
    }

    public Integer getGoal() {
        return this.goal;
    }

    public String show() {
        return this.name + " : " + this.state;
    }
}
