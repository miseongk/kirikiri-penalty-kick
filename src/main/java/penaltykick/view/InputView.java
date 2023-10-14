package penaltykick.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import penaltykick.constant.Constant;
import penaltykick.constant.errorMessage.PlayerInputPositionError;

public class InputView {
	public static final String INPUT_PLAYER_ONE_MESSAGE = "플레이어1 : ";
	public static final String INPUT_PLAYER_TWO_MESSAGE = "플레이어2 : ";

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String inputPlayerPosition() {
		String input = Constant.BLANK_VALUE;
		try {
			input = getInput();
			validateBlankPlayerInput(input);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return input;
	}

	private static void validateBlankPlayerInput(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException(PlayerInputPositionError.PLAYER_INPUT_BLANK_ERROR_MESSAGE);
		}
	}

	private static String getInput() throws IOException {
		return br.readLine();
	}
}
