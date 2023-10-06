package penaltykick.view;

import java.util.Map;
import penaltykick.domain.RoundResult;
import penaltykick.domain.GoalResult;

public class OutputView {
    private static final String GOAL_SIGN = "O";
    private static final String NO_GOAL_SIGN = "X";
    private static final Map<GoalResult, String> RESULT_SIGN_MAP = Map.of(
            GoalResult.GOAL, GOAL_SIGN,
            GoalResult.NO_GOAL, NO_GOAL_SIGN
    );

    private OutputView() {}

    public static void printGameStartMessage(int count) {
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.printf("총 %d번의 위치를 입력해주세요.\n", count);
    }

    public static void printGameResultMessage() {
        System.out.println();
        System.out.println("게임 결과");
    }

    public static void printRoundResult(RoundResult roundResult) {
        System.out.printf("%s : ", roundResult.getPlayerName());

        roundResult.getGoalResults().stream()
                .map(RESULT_SIGN_MAP::get)
                .forEach(System.out::print);

        System.out.println();
    }

    public static void printWinner(String name) {
        System.out.printf("%s이(가) 우승했습니다\uD83C\uDF89\n", name);
    }

    public static void printDraw() {
        System.out.println("무승부입니다.");
    }
}
