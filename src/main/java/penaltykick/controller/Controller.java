package penaltykick.controller;

import penaltykick.domain.Goalkeeper;
import penaltykick.domain.Player;
import penaltykick.view.OutputMessage;

public class Controller {
    Player player1;
    Player player2;
    Goalkeeper goalkeeper;

    public void run(){
        startGame();
        getPlayerNum();
        getGoalkeeperNum();
        showGameResult();
    }

    private void startGame() {
        OutputMessage.gameStartMessage();
    }

}
