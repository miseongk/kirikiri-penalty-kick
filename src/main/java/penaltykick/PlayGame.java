package penaltykick;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PlayGame {
    private Keeper keeper;
    private List<Player> players;

    public PlayGame(Keeper keeper, List<Player> players) {
        this.keeper = keeper;
        this.players = players;
    }

    public void startGame(BufferedReader br, String message) throws IOException {
        for (int i = Constants.PLAYER_MIN_RANGE; i <= Constants.PLAYER_MAX_RANGE; i++) {
            System.out.print(message  + i + " : ");
            players.get(i - 1).savedKick(
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
    }

    public void analyzingGame() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setScore(checkScore(i));
        }
    }

    public int gameResult() {
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        int play1Score = countScore(player1);
        int play2Score = countScore(player2);

        if (isDraw(play1Score, play2Score)) return Constants.DRAW_RESULT;
        if (play1Score > play2Score) return player1.getId();

        return player2.getId();
    }

    private int countScore(Player player) {
        int score = 0;
        String[] scoreBoard = player.getScore();
        for (int i = 0; i < scoreBoard.length; i++) {
            if (scoreBoard[i].equals("O")) score++;
        }
        return score;
    }

    private boolean isDraw(int p1, int p2) {
        return p1 == p2;
    }

    private String[] checkScore(int playerNumber) {
        Player player = players.get(playerNumber);
        String[] score = player.getScore();

        for (int i = 0; i < Constants.TOTAL_KICK; i++) {
            if (compareComputerAndPlayer(player.getKickDirection()[i], i)) {
                score[i] = "O";
                continue;
            }
            score[i] = "X";
        }
        return score;
    }

    private boolean compareComputerAndPlayer(int kickDirection, int kickCount) {
        int[] savedDirection = keeper.getSaveDirection();
        if (savedDirection[kickCount] == kickDirection) return true;
        return false;
    }

}
