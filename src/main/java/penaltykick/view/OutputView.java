package penaltykick.view;

import penaltykick.domain.Player;

public class OutputView {

    public void printGameStart() {
        System.out.println("패널티 킥 게임을 시작합니다.");
    }

    public void printGameResultTitle() {
        System.out.println("게임 결과");
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
