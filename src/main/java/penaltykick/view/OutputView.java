package penaltykick.view;

import java.util.List;

import penaltykick.domain.GameResult;

public class OutputView {
	private static final String GAME_START_FIRST_MESSAGE = "패널티 킥 게임을 시작합니다.";
	private static final String GAME_START_SECOND_MESSAGE = "총 5번의 위치를 입력해주세요.";
	private static final String GAME_CLEAR_MESSAGE = "게임 결과";
	private static final String GAME_ENDED_TIE_MESSAGE = "무승부입니다.";
	private static final String OUTPUT_PLAYER_ONE_MESSAGE = "플레이어1 : ";
	private static final String OUTPUT_PLAYER_TWO_MESSAGE = "플레이어2 : ";
	private static final String WINNER_PLAYER_ONE_MESSAGE = "플레이어1이(가) 우승했습니다\uD83C\uDF89";
	private static final String WINNER_PLAYER_TWO_MESSAGE = "플레이어2이(가) 우승했습니다\uD83C\uDF89";
	private static final String GOAL_SUCCESS = "O";
	private static final String GOAL_FAIL = "X";
	private final GameResult playerOneResult;
	private final GameResult playerTwoResult;

	public OutputView(GameResult playerOneResult, GameResult playerTwoResult) {
		this.playerOneResult = playerOneResult;
		this.playerTwoResult = playerTwoResult;
	}

	public void printGameResult() {
		printPlayerResult();
	}

	public static void printStartMessage() {
		System.out.println(GAME_START_FIRST_MESSAGE);
		System.out.println(GAME_START_SECOND_MESSAGE);
	}

	public void printClearMessage() {
		System.out.println("\n" + GAME_CLEAR_MESSAGE + "\n"
			+ OUTPUT_PLAYER_ONE_MESSAGE + playerResultConvert(playerOneResult.convertResult) + "\n"
			+ OUTPUT_PLAYER_TWO_MESSAGE + playerResultConvert(playerTwoResult.convertResult));
	}

	public String playerResultConvert(List<Boolean> playerResult) {
		StringBuilder sb = new StringBuilder();
		for (boolean val : playerResult) {
			sb.append(resultConvert(val));
		}
		return sb.toString();
	}

	private String resultConvert(boolean playerResultVal) {
		if (playerResultVal) {
			return GOAL_SUCCESS;
		}
		return GOAL_FAIL;
	}

	private void printPlayerResult() {
		if (playerOneResult.goalCount > playerTwoResult.goalCount) {
			System.out.println(WINNER_PLAYER_ONE_MESSAGE);
		}
		if (playerOneResult.goalCount < playerTwoResult.goalCount) {
			System.out.println(WINNER_PLAYER_TWO_MESSAGE);
		}
		if (playerOneResult.goalCount == playerTwoResult.goalCount) {
			System.out.println(GAME_ENDED_TIE_MESSAGE);
		}
	}
}
