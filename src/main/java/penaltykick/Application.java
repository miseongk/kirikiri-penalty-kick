package penaltykick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Print print = new Print();
        List<Player> players = List.of(new Player(Constants.PLAYER_MIN_RANGE), new Player(Constants.PLAYER_MAX_RANGE));
        PlayGame playGame = new PlayGame(new Keeper(), players);

        // 게임 시작
        print.startGame();
        playGame.startGame(br, print.inputKickByPlayer());
        playGame.analyzingGame();
        int winner = playGame.gameResult();

        // 게임 종료
        print.endGame();
        print.playerScoreBoard(players);
        print.resultOfPlayer(winner);
    }

    static class Print {
        public Print() {
        }

        public void startGame() {
            System.out.println("패널티 킥 게임을 시작합니다.");
            System.out.println("총 " + Constants.TOTAL_KICK + "번의 위치를 입력해주세요.");
        }

        public String inputKickByPlayer() {
            return "플레이어";
        }

        public void endGame() {
            System.out.println();
            System.out.println("게임 결과");
        }

        public void resultOfPlayer(int number) {
            if (number == Constants.DRAW_RESULT) {
                System.out.println("무승부입니다.");
            }
            System.out.println("플레이어" + number + "이(가) 우승했습니다.");
        }

        public void playerScoreBoard(List<Player> players) {
            for (Player player : players) {
                System.out.print("플레이어" + player.getId() + " : ");
                for (String score : player.getScore()) {
                    System.out.print(score);
                }
                System.out.println();
            }
        }
    }
}
