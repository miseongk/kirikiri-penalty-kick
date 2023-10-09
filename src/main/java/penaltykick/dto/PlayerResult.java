package penaltykick.dto;

import penaltykick.domain.Player;

public class PlayerResult {

    private final Character GOAL = 'O';
    private final Character NO_GOAL = 'X';
    private final String name;
    private String state;

    private Integer goal;

    public PlayerResult(String playerName) {
        name = playerName;
        state = "";
        goal = 0;
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

    public void setState(Character token) {
        if (token == GOAL) {
            state += GOAL;
            goal += 1;
        } else {
            state += NO_GOAL;
        }
    }

    public String show() {
        return getName() + " : " + getState();
    }
}
