package penaltykick.controller;

import penaltykick.domain.Goalkeeper;
import penaltykick.domain.Player;
import penaltykick.service.Service;
import penaltykick.utils.Util;
import penaltykick.view.InputMessage;
import penaltykick.view.OutputMessage;

import java.util.ArrayList;

public class Controller {
    Player player1;
    Player player2;
    Goalkeeper goalkeeper;

    public void run() {
        startGame();
        getPlayerNum();
        getGoalkeeperNum();
        showGameResult();
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

    private void getGoalkeeperNum() {
        goalkeeper = new Goalkeeper();
    }

    private void showGameResult() {
        Service service = new Service();
        player1.setNumberOfWins(service.countGoal(goalkeeper.getGoalkeeperRandomNumber(), player1.getPlayerNumber()));
        player2.setNumberOfWins(service.countGoal(goalkeeper.getGoalkeeperRandomNumber(), player2.getPlayerNumber()));

        player1.setResult(service.resultOfGoal(goalkeeper.getGoalkeeperRandomNumber(), player1.getPlayerNumber()));
        player2.setResult(service.resultOfGoal(goalkeeper.getGoalkeeperRandomNumber(), player2.getPlayerNumber()));

        OutputMessage.gameResultMessage();

        OutputMessage.player1Message();
        OutputMessage.Message(player1.getResult());
        OutputMessage.player2Message();
        OutputMessage.Message(player2.getResult());
        OutputMessage.Message(service.gameResult(player1.getNumberOfWins(), player2.getNumberOfWins()));

    }
}
