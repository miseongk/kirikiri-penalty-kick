package penaltykick.dto;

public class GameResult {
    private final String winner;
    private final Boolean draw;

    public GameResult(String gameWinner, Boolean check) {
        winner = gameWinner;
        draw = check;
    }

    public String getWinner() {
        return this.winner;
    }

    public Boolean isDraw() {
        return this.draw;
    }

}
