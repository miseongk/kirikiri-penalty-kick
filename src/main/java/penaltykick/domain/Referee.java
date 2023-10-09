package penaltykick.domain;

import penaltykick.dto.GameResult;
import penaltykick.dto.PlayerResult;

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

    public PlayerResult generatePlayerResult(ArrayList<Integer> goalkeeperNumbers, ArrayList<Integer> playerNumbers, PlayerResult playerResult) {
        for (int i=0; i<LIMIT; i++) {
            checkGoalOrNot(goalkeeperNumbers.get(i), playerNumbers.get(i), playerResult);
        }
        return playerResult;
    }

    public void checkGoalOrNot(Integer goalkeeperNumber, Integer playerNumber, PlayerResult playerResult) {
        if (goalkeeperNumber == playerNumber) {
            playerResult.setState(GOAL);
        } else {
            playerResult.setState(NO_GOAL);
        }
    }

    public GameResult decideWinner(PlayerResult player1Result, PlayerResult player2Result) {
        System.out.println();
        System.out.println(SHOW_GAME_RESULT);

        System.out.println(player1Result.show());
        System.out.println(player2Result.show());

        if (player1Result.getGoal() > player2Result.getGoal()) {
            return new GameResult(player1Result.getName(), false);
        } else if (player1Result.getGoal() == player2Result.getGoal()) {
            return new GameResult(null, true);
        } else {
            return new GameResult(player2Result.getName(), false);
        }
    }


    public void notifyStartGame() {
        System.out.println(START_GAME);
        System.out.println(ASK_NUMBER);
    }

    public void notifyAskNumbers(String playerName) {
        System.out.print(playerName + " : ");
    }

    public void notifyGameResult(GameResult gameResult) {
        if (gameResult.isDraw()) {
            System.out.println(NOTIFY_DRAW);
        } else {
            System.out.println(gameResult.getWinner() + NOTIFY_WINNER);
        }
    }
}
