package penaltykick.controller;

import penaltykick.domain.Goalkeeper;
import penaltykick.domain.Player;
import penaltykick.utils.Util;
import penaltykick.view.InputMessage;
import penaltykick.view.OutputMessage;

import java.util.ArrayList;

public class Controller {
    Player player1;
    Player player2;
    Goalkeeper goalkeeper;

    public void run(){
        startGame();
        getPlayerNum();
//        getGoalkeeperNum();
//        showGameResult();
    }

    private void startGame() {
        OutputMessage.gameStartMessage();
    }

    private void getPlayerNum() {
        OutputMessage.player1Message();
        player1 = new Player(getInputPlayerNum());

        OutputMessage.player2Message();
        player2 = new Player(getInputPlayerNum());
    }

    private ArrayList<Integer> getInputPlayerNum() {
        InputMessage inputMessage = new InputMessage();
        return Util.stringToIntegerArrayList(inputMessage.inputNumber());
    }
}
