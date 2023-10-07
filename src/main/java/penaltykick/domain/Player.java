package penaltykick.domain;

import java.util.ArrayList;

public class Player {
    private static final int PLAYER_MIN_NUMBER = 1;
    private static final int PLAYER_MAX_NUMBER = 3;

    private ArrayList<Integer> playerNumber = new ArrayList<>();
    private String result; //출력할 내용 게터 세터
    private int numberOfWins; //맞춘 개수 게터 세터

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public String getResult() {
        return this.result;
    }

    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    public Player(ArrayList playerNumber) {
        this.playerNumber = playerNumber;

    }

    public ArrayList<Integer> getPlayerNumber(){
        return this.playerNumber;
    }

}
