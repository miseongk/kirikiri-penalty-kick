package penaltykick;

import domain.Computer;
import domain.Player;
import validator.Validator;

import java.util.Random;
import java.util.Scanner;

public class Application {
    static void comparePlayers(String player1, String player2) {
        int player1_win_count = player1.replaceAll("X","").length();
        int player2_win_count = player2.replaceAll("X", "").length();

        if (player1_win_count == player2_win_count) {
            System.out.println("무승부입니다.");
        }
        if (player1_win_count > player2_win_count) {
            System.out.println("플레이어1이(가) 우승했습니다.");
        }
        if (player1_win_count < player2_win_count) {
            System.out.println("플레이어2이(가) 우승했습니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 안내 문구
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.println("총 5번의 위치를 입력해주세요.");

        // 사용자값 입력 받기
        Scanner scanner = new Scanner(System.in);

        String player1_input = null;
        String player2_input = null;

        try {
            System.out.print("플레이어1 : ");
            player1_input = scanner.nextLine();

            //유효성 검증
            Validator.validate(player1_input);

            System.out.print("플레이어2 : ");
            player2_input = scanner.nextLine();

            Validator.validate(player2_input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Player player1 = new Player(player1_input);
        Player player2 = new Player(player2_input);

        //컴퓨터 숫자 생성
        Computer computer = new Computer();

        String player1_win_count = computer.getGameResult(player1.getNumbers());
        String player2_win_count = computer.getGameResult(player2.getNumbers());

        // 플레이어 1,2의 결과를 출력
        System.out.println("게임 결과");

        System.out.println("플레이어1 : " + player1_win_count);

        System.out.println("플레이어2 : " + player2_win_count);

        // 비교한 결과를 출력
        comparePlayers(player1_win_count, player2_win_count);
    }
}
