package penaltykick;

import java.util.ArrayList;
import java.util.List;


public class Utils {

	public static List<Integer> randomIntListInRange(int startInclusive, int endInclusive, int count) {
		List<Integer> result = new ArrayList<>();
		while (result.size() < count) {
			result.add(getRandomIntInRange(startInclusive, endInclusive));
		}
		return result;
	}

	private static int getRandomIntInRange(int startInclusive, int endInclusive) {
		return (int) Math.random() * (endInclusive + 1) - startInclusive;
	}

	public static boolean isInRange(int startInclusive, int endInclusive, int targetNum) {
		return startInclusive <= targetNum && targetNum <= endInclusive;
	}
}
