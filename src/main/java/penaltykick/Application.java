package penaltykick;

import domain.Computer;
import domain.Player;

import java.util.Random;
import java.util.Scanner;

public class Application {
    static void validate(String player) {
        if ("".equals(player)) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
        if (!player.replaceAll(" ", "").matches("^[0-9]*$")) {
            throw new IllegalArgumentException("공백으로 구분해서 입력해야 합니다.");
        }

        String[] numbers = player.split(" ");

        if (numbers.length != 5) {
            throw new IllegalArgumentException("5개의 값을 입력해야 합니다.");
        }

        for (String number : numbers) {
            if (Integer.valueOf(number) < 1 || Integer.valueOf(number) > 3) {
                throw new IllegalArgumentException("1-3 사이의 값만 입력할 수 있습니다.");
            }
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
            validate(player1_input);

            System.out.print("플레이어2 : ");
            player2_input = scanner.nextLine();

            validate(player2_input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Player player1 = new Player(player1_input);
        Player player2 = new Player(player2_input);

        //컴퓨터 숫자 생성
        Computer computer = new Computer();

        // 플레이어 1,2의 결과를 출력
        System.out.println("게임 결과");

        System.out.println("플레이어1 : " + computer.getGameResult(player1.getNumbers()));

        System.out.println("플레이어2 : " + computer.getGameResult(player2.getNumbers()));

        // 비교한 결과를 출력
    }
}
