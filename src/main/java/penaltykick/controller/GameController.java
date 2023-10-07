package penaltykick.controller;

import penaltykick.domain.GoalKeeper;
import penaltykick.domain.Player;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Player player1 = progressPenaltyKickPositionSetting();
        Player player2 = progressPenaltyKickPositionSetting();
        GoalKeeper goalKeeper = new GoalKeeper();

        progressPenaltyKick();
        progressMatchResult();
    }

    private Player progressPenaltyKickPositionSetting() {
    }

    private void progressPenaltyKick() {
    }

    private void progressMatchResult() {
    }
}
