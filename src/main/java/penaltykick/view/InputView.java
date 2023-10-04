package penaltykick.view;

import penaltykick.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
	public static List<Integer> readIntListWithDiv(String message, String delimiter) {
		System.out.printf(message);
		String input = readLine();
		return Arrays.stream(input.split(delimiter))
				.map(Utils::stringToInt)
				.collect(Collectors.toList());
	}



	private static String readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new IllegalArgumentException("입력단계에서 예외가 발생하였습니다.");
		}
	}
}
