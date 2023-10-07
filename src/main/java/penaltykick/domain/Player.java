package penaltykick.domain;

import java.util.List;

public class Player {

    private final static String KICK_SUCCESS = "O";
    private final static String KICK_FAIL = "X";

    private String name;
    private List<Integer> penaltyKickPosition;
    private String penaltyKickResult;
    private int score;

    public Player(int playerNum, List<Integer> penaltyKickPosition) {
        validateKickPosition(penaltyKickPosition);
        this.name = "플레이어" + playerNum;
        this.penaltyKickPosition = penaltyKickPosition;
        this.penaltyKickResult = "";
        this.score = 0;
    }

    private void validateKickPosition(List<Integer> penaltyKickPosition) {
        for (int position : penaltyKickPosition) {
            if (position < 1 || position > 3) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void progressPenaltyKick(GoalKeeper goalKeeper) {
        List<Integer> goalKeeperDefensePosition = goalKeeper.getDefensePosition();

        for (int i = 0; i < 5; i++) {
            if (penaltyKickPosition.get(i) != goalKeeperDefensePosition.get(i)) {
                penaltyKickResult += KICK_SUCCESS;
                score++;
            }

            if (penaltyKickPosition.get(i) == goalKeeperDefensePosition.get(i)) {
                penaltyKickResult += KICK_FAIL;
            }
        }
    }

    public boolean isVictory(Player competitor) {
        int competitorScore = competitor.getScore();

        if (score > competitorScore) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPenaltyKickPosition() {
        return penaltyKickPosition;
    }

    public String getPenaltyKickResult() {
        return penaltyKickResult;
    }

    public int getScore() {
        return score;
    }
}
