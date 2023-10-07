package penaltykick.controller;

import penaltykick.domain.GoalKeeper;
import penaltykick.domain.Player;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

import java.util.List;

public class GameController {

    private final int PLAYER_NUMBER_ONE = 1;
    private final int PLAYER_NUMBER_TWO = 2;

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Player player1 = progressPenaltyKickPositionSetting(PLAYER_NUMBER_ONE);
        Player player2 = progressPenaltyKickPositionSetting(PLAYER_NUMBER_TWO);
        GoalKeeper goalKeeper = new GoalKeeper();

        progressPenaltyKick(player1, player2, goalKeeper);
        progressMatchResult();
    }

    private Player progressPenaltyKickPositionSetting(int playerNum) {
        List<Integer> penaltyKickPosition = inputView.readPenaltyKickPosition(playerNum);
        return new Player(playerNum, penaltyKickPosition);
    }

    private void progressPenaltyKick(Player player1, Player player2, GoalKeeper goalKeeper) {
        player1.progressPenaltyKick(goalKeeper);
        player2.progressPenaltyKick(goalKeeper);
    }

    private void progressMatchResult() {
    }
}
