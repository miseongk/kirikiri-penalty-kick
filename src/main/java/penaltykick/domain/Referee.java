package penaltykick.domain;

import penaltykick.dto.Result;

import java.util.ArrayList;

public class Referee {

    private final String START_GAME = "패널티 킥 게임을 시작합니다.";
    private final String ASK_NUMBER = "총 5번의 위치를 입력해주세요.";
    private final String SHOW_GAME_RESULT = "게임 결과";
    private final String NOTIFY_WINNER = "이(가) 우승했습니다\uD83C\uDF89";
    private final String NOTIFY_DRAW = "무승부입니다.";

    private final Character GOAL = 'O';
    private final Character NO_GOAL = 'X';
    static final Integer LIMIT = 5;

    public Referee() {
    }

    public Result decideGoalOrNot(ArrayList<Integer> goalkeeperNumbers, ArrayList<Integer> playerNumbers, String playerName) {
        String state = "";
        int countGoal = 0;

        for (int i=0; i<LIMIT; i++) {
            if (goalkeeperNumbers.get(i) == playerNumbers.get(i)) {
                state += GOAL;
                countGoal += 1;
            } else {
                state += NO_GOAL;
            }
        }
        return new Result(state, countGoal, playerName, false);
    }

    public Result decideWinner(Result state1, Result state2) {
        System.out.println();
        System.out.println(SHOW_GAME_RESULT);

        System.out.println(state1.show());
        System.out.println(state2.show());

        if (state1.getGoal() > state2.getGoal()) {
            return state1;
        } else if (state1.getGoal() == state2.getGoal()) {
            return new Result(null, null, null, true);
        } else {
            return state2;
        }
    }

    public void notifyStartGame() {
        System.out.println(START_GAME);
        System.out.println(ASK_NUMBER);
    }

    public void notifyAskNumbers(String playerName) {
        System.out.print(playerName + " : ");
    }

    public void notifyGameResult(Result result) {
        if (result.getDraw()) {
            System.out.println(NOTIFY_DRAW);
        } else {
            System.out.println(result.getPlayerName() + NOTIFY_WINNER);
        }
    }
}
