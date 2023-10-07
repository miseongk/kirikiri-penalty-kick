package penaltykick.controller;

import penaltykick.domain.CompareResult;
import penaltykick.domain.Computer;
import penaltykick.domain.Goal;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    List <Integer> player1 = InputView.getPlayer1();
    List <Integer> player2 = InputView.getPlayer2();

    CompareResult compareResult = new CompareResult();
    List <String> player1Result = compareResult.getPlayer1Result();
    List <String> player2Result = compareResult.getPlayer2Result();

    public void gameStart(){
        outputView.printInputStart();
        outputView.printUserLocation();
        inputView.inputPlayer1();
        inputView.inputPlayer2();

        System.out.println();
        outputView.printGameResult();
        outputView.printPlayer1();
        compareResult.comparePlayer1(player1);
        outputView.printPlayer2();
        compareResult.comparePlayer2(player2);
        compareResult.compareGoals(player1Result , player2Result);
    }

}
