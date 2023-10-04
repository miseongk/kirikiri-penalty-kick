package penaltykick;

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
        if (player.split(" ").length != 5) {
            throw new IllegalArgumentException("5개의 값을 입력해야 합니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 안내 문구
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.println("총 5번의 위치를 입력해주세요.");

        // 사용자값 입력 받기
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("플레이어1 : ");
            String player1 = scanner.nextLine();

            //유효성 검증
            validate(player1);

            System.out.print("플레이어2 : ");
            String player2 = scanner.nextLine();

            validate(player2);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
