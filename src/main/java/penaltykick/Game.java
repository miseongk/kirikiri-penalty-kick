package penaltykick;

import penaltykick.Utill.Validation;
import penaltykick.domain.Player;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;
import java.util.ArrayList;
import java.util.List;

import static penaltykick.Utill.Reference.INPUT_COUNT;
import static penaltykick.Utill.Reference.PLAYER_COUNT;

public class Game {


    private final OutputView OUTPUT_VIEW ;
    private final InputView INPUT_VIEW ;
    private final Validation VALIDATION;
    private static final List<Player> PLAYER_INPUT = new ArrayList<>();
    private static final List<Integer> computerDirectionList = new ArrayList<>();

    public Game(OutputView outputView, InputView inputView , Validation validation){
        this.OUTPUT_VIEW = outputView;
        this.INPUT_VIEW = inputView;
        this.VALIDATION = validation;
    }
    public void run(){
        OUTPUT_VIEW.printStartMessage();
        INPUT_VIEW.readInputController(PLAYER_INPUT);
        makeComputerDirectionList();
        VALIDATION.isValid(PLAYER_INPUT);
        calculateResult(computerDirectionList);
        OUTPUT_VIEW.printResult(PLAYER_INPUT);
        OUTPUT_VIEW.printWinner(getWinner());
    }
    public int getWinner(){
        if(PLAYER_INPUT.get(0).getPoint() > PLAYER_INPUT.get(1).getPoint()) return 1;
        if(PLAYER_INPUT.get(0).getPoint() < PLAYER_INPUT.get(1).getPoint()) return 2;
        return 0;
    }
    public void calculateResult(List<Integer> computerDirectionList){
        for (int i = 0; i < PLAYER_COUNT; i++)
            PLAYER_INPUT.get(i).calculatePoint(computerDirectionList);
    }
    public void makeComputerDirectionList(){
        for(int i = 0 ; i < INPUT_COUNT;i++)
            computerDirectionList.add((int)(Math.random() * 3) + 1);
    }
}
