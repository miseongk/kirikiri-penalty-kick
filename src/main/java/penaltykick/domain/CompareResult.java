package penaltykick.domain;

import penaltykick.view.InputView;
import penaltykick.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CompareResult {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    Computer computer = new Computer();
    List <Integer> computerPosition = computer.computerPosition();

    List<String> player1Result = new ArrayList<>();
    List<String> player2Result = new ArrayList<>();

    public List<String> getPlayer1Result() {
        return player1Result;
    }

    public List<String> getPlayer2Result() {
        return player2Result;
    }

    public List <String> comparePlayer1 (List <Integer> player) {
        for(int i = 0; i < Goal.POSITION_LENGTH.getValue(); i++){
            if (player.get(i).equals(computerPosition.get(i))) {
                player1Result.add("O");
            } else {
                player1Result.add("X");
            }
            System.out.print(player1Result.get(i));
        }
        System.out.println();
        return player1Result;
    }

    public List <String> comparePlayer2 (List <Integer> player) {
        for(int i = 0; i < Goal.POSITION_LENGTH.getValue(); i++){
            if (player.get(i).equals(computerPosition.get(i))) {
                player2Result.add("O");
            } else {
                player2Result.add("X");
            }
            System.out.print(player2Result.get(i));
        }
        System.out.println();
        return player2Result;
    }

    public void compareGoals (List <String> player1Result, List<String> player2Result) {
        int player1Goals = 0;
        int player2Goals = 0;
        for(int i = 0; i < player1Result.size(); i++){
            if (player1Result.get(i).equals("O")){
                player1Goals++;
            }
        }

        for(int i = 0; i < player2Result.size(); i++){
            if (player2Result.get(i).equals("O")){
                player2Goals++;
            }
        }
        printPlayerResult(player1Goals , player2Goals);
    }

    public void printPlayerResult(int player1Goals, int player2Goals) {
        if (player1Goals > player2Goals) {
            outputView.printPlayer1Win();
        }

        else if (player1Goals == player2Goals) {
            outputView.printDraw();
        }

        else {
            outputView.printPlayer2Win();
        }
    }

}
