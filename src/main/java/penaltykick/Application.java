package penaltykick;

import java.io.*;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Player player1 = new Player();
        Player player2 = new Player();
        GoalKeeper goalKeeper;
        Referee referee = new Referee();
        StringTokenizer st;

        System.out.println("패널티 킥 게임을 시작합니다.\n" +
                            "총 5번의 위치를 입력해주세요.");

        // 플레이어 1, 2 입력 받기
        System.out.print("플레이어1 : ");
        st = new StringTokenizer(br.readLine());
        player1.playerInput(st);

        System.out.print("플레이어2 : ");
        st = new StringTokenizer(br.readLine());
        player2.playerInput(st);


        // 골키퍼(컴퓨터)가 랜덤으로 숫자 생성하기(5개)
        goalKeeper = new GoalKeeper();

        // 골키퍼(컴퓨터)와 플레이어들의 숫자를 비교하여 다르면 골 넣기 성공(O), 같으면 골 넣기 실패(X)
        // 리팩토링할 곳 찾아보기
        for(int i=0; i<5; i++){
            player1.inputScoreArr(i, referee.isPlayerScoreGoal(goalKeeper.goalKeeperGoal(i), player1.getPlayerGoal(i)));
            player2.inputScoreArr(i, referee.isPlayerScoreGoal(goalKeeper.goalKeeperGoal(i), player2.getPlayerGoal(i)));
        }

        // 게임 결과 출력
        System.out.println("\n게임 결과");
        System.out.print("플레이어1 : ");
        System.out.print(player1.playerGameResult());

        System.out.println();
        System.out.print("플레이어2 : ");
        System.out.println(player2.playerGameResult());

        referee.gameResult(player1.getScore(), player2.getScore());

    }
}
