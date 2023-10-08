package penaltykick.controller;

import penaltykick.domain.Player;
import penaltykick.utill.Validation;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static penaltykick.utill.Reference.ERROR_MESSAGE;
import static penaltykick.utill.Reference.INPUT_COUNT;

public class GameController {
    private static final List<Player> playerList = new ArrayList<>();
    private static final List<Integer> computerDirectionList = new ArrayList<>();
    private final OutputView outputView;
    private final InputView inputView;
    private final Validation validation;
    private static boolean validSign = true;

    public GameController(OutputView outputView, InputView inputView, Validation validation) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.validation = validation;
    }

    public void run() {
        outputView.printStartMessage();
        readManager();
        makeComputerDirectionList();
        calculateResult(computerDirectionList);
        outputView.printResult(playerList);
        outputView.printWinner(getWinner());
    }
    public void readManager(){
        inputView.readInputController(playerList);
        validSign = validation.isValid(playerList);
        while(!validSign){
            reloadList();
        }
    }
    public void reloadList(){
        inputView.printError();
        playerList.clear();
        inputView.readInputController(playerList);
        validSign = validation.isValid(playerList);

    }

    public int getWinner() {
        if (playerList.get(0).getPoint() > playerList.get(1).getPoint()) {
            return 1;
        }
        if (playerList.get(0).getPoint() < playerList.get(1).getPoint()) {
            return 2;
        }
        return 0;
    }

    public void calculateResult(List<Integer> computerDirectionList) {
        for (Player player : playerList) {
            player.calculatePoint(computerDirectionList);
        }
    }

    public void makeComputerDirectionList() {
        for (int i = 0; i < INPUT_COUNT; i++)
            computerDirectionList.add((int) (Math.random() * 3) + 1);
    }
}
