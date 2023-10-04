package penaltykick.view;

import penaltykick.domain.Player;

import java.util.List;

import static penaltykick.Utill.Reference.*;

public class OutputView {

    private static OutputView outputView;

    private OutputView(){}

    public static OutputView getInstance(){
        if(outputView == null)
            return new OutputView();
        return outputView;
    }
    public void printWinner(int winner) {
        if(winner == 0) {
            System.out.println(TIE_MESSAGE);
            return;
        }
        System.out.println(String.format(WINNER_MESSAGE,winner));
    }

    public void printStartMessage(){
        System.out.println(START_GAME_MSG);
        System.out.printf(POSITION_MESSAGE,INPUT_COUNT);
    }

    public void printResult(List<Player> list){
        for(int i = 0 ; i < PLAYER_COUNT;i++)
            System.out.println(String.format(PLAYER_MESSAGE,i + 1) + list.get(i).getResultList());
    }
}
