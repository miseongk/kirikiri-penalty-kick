package penaltykick;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 플레이어
 * 유저의 입력을 받아 패너틸킥을 차는 책임을 가집니다.
 */
public class Player {
    private final int id; //플레이어 고유 번호
    private final GoalPost[] kickPositionArr; //플레이어의 킥 방향

    public Player(int id, int totalNumberOfGoal) {
        this.id = id;
        this.kickPositionArr = new GoalPost[totalNumberOfGoal];
    }

    /**
     * 유저의 패널티킥을 입력 받습니다.
     */
    public void kickIntoGoal() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("플레이어%d : ", id);
        String kick = sc.nextLine();
        checkString(kick);
        int[] array = Arrays.stream(kick.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < kickPositionArr.length; i++) {
            kickPositionArr[i] = new GoalPost(array[i]);
        }
    }

    /**
     * 사용자의 입력 받은 문자열이 5개의 숫자와 공백으로 이루어졌는지 체크한다.
     */
    private void checkString(String str) {
        String pattern = "^(\\d+\\s){4}\\d+$";
        if (!Pattern.matches(pattern, str)) {
            throw new IllegalArgumentException("숫자5개 공백으로 이루어져야 합니다.");
        }
    }

    public int getId() {
        return id;
    }
    public GoalPost[] getKickPositionArr(){
        return kickPositionArr.clone();
    }
}
