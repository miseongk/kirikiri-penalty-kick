package penaltykick.view;

import penaltykick.domain.Player;

public class OutputView {

    public void printGameStart() {
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.println("총 5번의 패널티 킥 위치를 입력해주세요.");
    }

    public void printGameResultTitle() {
        System.out.println("\n게임 결과");
    }

    public void printPlayerPenaltyKickResult(Player player) {
        System.out.println(player.getName() + " : " + player.getPenaltyKickResult());
    }

    public void printMatchWinner(Player player) {
        System.out.println(player.getName() + "이(가) 우승했습니다!");
    }

    public void printMatchDraw() {
        System.out.println("무승부입니다.");
    }
}
