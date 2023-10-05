package penaltykick.view;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
	private static final String INPUT_PLAYER_ONE_MESSAGE = "플레이어1 : ";
	private static final String INPUT_PLAYER_TWO_MESSAGE = "플레이어2 : ";
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String printInputPlayerOneMessage() throws IOException {
		System.out.print(INPUT_PLAYER_ONE_MESSAGE);
		return br.readLine();
	}

	public static String printInputPlayerTwoMessage() throws IOException {
		System.out.print(INPUT_PLAYER_TWO_MESSAGE);
		return br.readLine();
	}
}
