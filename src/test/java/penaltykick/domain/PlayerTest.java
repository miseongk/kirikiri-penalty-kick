package penaltykick.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("플레이어 초기값 세팅 - 입력값 정상")
    @Test
    void setPlayer_with_correct_input() {
        // given
        int playerNum = 1;
        List<Integer> penaltyKickPosition = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            penaltyKickPosition.add(1);
        }

        // when
        Player player = new Player(playerNum, penaltyKickPosition);

        // then
        assertEquals(player.getName(), "플레이어1");
        assertEquals(player.getPenaltyKickPosition(), penaltyKickPosition);
        assertEquals(player.getPenaltyKickResult(), "");
        assertEquals(player.getScore(), 0);
    }

    @DisplayName("플레이어 초기값 세팅 - 입력값 오류")
    @Test
    void setPlayer_with_wrong_input() {
        // given
        int playerNum = 1;
        List<Integer> penaltyKickPosition = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            penaltyKickPosition.add(5);
        }

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(playerNum, penaltyKickPosition);
        });
    }

    @DisplayName("패널티킥 진행")
    @Test
    void progressPenaltyKick() {
        // given
        int playerNum = 1;
        List<Integer> penaltyKickPosition = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            penaltyKickPosition.add(1);
        }
        Player player = new Player(playerNum, penaltyKickPosition);
        GoalKeeper goalKeeper = new GoalKeeper();

        // when
        player.progressPenaltyKick(goalKeeper);

        // then
        assertEquals(player.getPenaltyKickResult().length(), 5);
    }
}