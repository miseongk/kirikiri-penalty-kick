package penaltykick.domain;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import penaltykick.constant.Constant;

public class ComputerPosition {
	private static final SecureRandom random = new SecureRandom();

	private static List<Integer> pickRandomPosition() {
		return Arrays.stream(new List[Constant.POSITION_LENGTH])
			.map(num -> random.nextInt(Constant.END_RANGE) + Constant.START_RANGE)
			.collect(Collectors.toList());
	}

	public List<Integer> getComputerPosition() {
		return pickRandomPosition();
	}
}
