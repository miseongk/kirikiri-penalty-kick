package penaltykick;

import java.util.ArrayList;
import java.util.List;

/**
 * 심판
 * -> 플레이어의 골 여부를 결정하고 승리여부를 알려줍니다.
 */
public class Referee {
    private final static char GOAL_SUCCESS = 'O';
    private final static char GOAL_MISS = 'X';

    /**
     * 게임결과를 출력합니다.
     */
    public void printGoalStatus(Player[] players, Goalkeeper goalkeeper) {
        List<Long> playerScoreArr = new ArrayList<>();
        for (Player player : players) {
            String goalScore = playerGoalScore(player.getKickPositionArr(), goalkeeper.getCatchPositionArr());
            printPlayerGoalScore(player.getId(), goalScore);
            playerScoreArr.add(goalScore.chars().filter(c -> c == GOAL_SUCCESS).count());
        }
        printPlayerMatchResult(playerScoreArr);
    }

    /**
     * 플레이어의 골 여부를 반홥합니다.
     */
    private String playerGoalScore(GoalPost[] kickPositionArr, GoalPost[] catchPositionArr) {
        StringBuilder output = new StringBuilder(kickPositionArr.length);
        for (int i = 0; i < kickPositionArr.length; i++){
            if (kickPositionArr[i].getLocation() == catchPositionArr[i].getLocation()) {
                output.append(GOAL_SUCCESS);
            }
            else {
                output.append(GOAL_MISS);
            }
        }
        return output.toString();
    }

    /**
     * 플레이어의 골 여부를 출력합니다.
     */
    private void printPlayerGoalScore(int playerNumber, String goalScore) {
        System.out.printf("플레이어%d : %s%n", playerNumber, goalScore);
    }

    /**
     * 플레이어들간의 경기 결과를 출력 합니다.
     */
    private void printPlayerMatchResult(List<Long> playerScoreArr) {
        int maxIndex = 0;
        Long maxValue = playerScoreArr.get(0);
        for (int i = 1; i < playerScoreArr.size(); i++) {
            if(playerScoreArr.get(i).compareTo(maxValue) == 0){
                System.out.println("무승부입니다.");
                return;
            }
            if (playerScoreArr.get(i).compareTo(maxValue) > 0) {
                maxValue = playerScoreArr.get(i);
                maxIndex = i;
            }
        }
        System.out.printf("플레이어%d이(가) 우승했습니다🎉", maxIndex + 1);
    }
}
