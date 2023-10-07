package penaltykick.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import penaltykick.view.OutputView;

class GameResultTest {
	@Test
	void 결과값_플레이어1_골_넷_플레이어2_골_셋() {
		List<Integer> comPos = List.of(2, 3, 3, 1, 3);
		List<Integer> playerOnePos = List.of(2, 3, 3, 1, 1);
		List<Integer> playerTwoPos = List.of(2, 3, 1, 2, 3);

		GameResult playerOneGameResult = new GameResult(comPos, playerOnePos);
		GameResult playerTwoGameResult = new GameResult(comPos, playerTwoPos);

		assertEquals(playerOneGameResult.goalCount, 4);
		assertEquals(playerTwoGameResult.goalCount, 3);
		assertEquals(playerOneGameResult.convertResult, "OOOOX");
		assertEquals(playerTwoGameResult.convertResult, "OOXXO");
	}

	@Test
	void 결과값_플레이어1_골_둘_플레이어2_골_다섯() {
		List<Integer> comPos = List.of(2, 3, 3, 1, 3);
		List<Integer> playerOnePos = List.of(2, 3, 1, 2, 1);
		List<Integer> playerTwoPos = List.of(2, 3, 3, 1, 3);

		GameResult playerOneGameResult = new GameResult(comPos, playerOnePos);
		GameResult playerTwoGameResult = new GameResult(comPos, playerTwoPos);

		assertEquals(playerOneGameResult.goalCount, 2);
		assertEquals(playerTwoGameResult.goalCount, 5);
		assertEquals(playerOneGameResult.convertResult, "OOXXX");
		assertEquals(playerTwoGameResult.convertResult, "OOOOO");
	}

	@Test
	void 결과값_골_없음() {
		List<Integer> comPos = List.of(2, 3, 3, 1, 3);
		List<Integer> playerOnePos = List.of(3, 2, 1, 2, 2);
		List<Integer> playerTwoPos = List.of(3, 2, 1, 2, 2);

		GameResult playerOneGameResult = new GameResult(comPos, playerOnePos);
		GameResult playerTwoGameResult = new GameResult(comPos, playerTwoPos);

		assertEquals(playerOneGameResult.goalCount, 0);
		assertEquals(playerTwoGameResult.goalCount, 0);
		assertEquals(playerOneGameResult.convertResult, "XXXXX");
		assertEquals(playerTwoGameResult.convertResult, "XXXXX");
	}

}