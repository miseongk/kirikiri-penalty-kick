package penaltykick.dto;

public class Result {

    private final String state;
    private final Integer goal;
    private final String playerName;
    private final Boolean isDraw;

    public Result(String result, Integer countGoal, String name, boolean draw) {
        state = result;
        goal = countGoal;
        playerName = name;
        isDraw = draw;
    }

    public String getState() {
        return state;
    }

    public Integer getGoal() {
        return goal;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Boolean getDraw() {
        return isDraw;
    }

    public String show() {
        return getPlayerName() + " : " + getState();
    }
}
