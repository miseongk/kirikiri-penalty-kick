package penaltykick.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import penaltykick.constant.Constant;

public class ComputerPosition {

	private final List<Integer> computerPosition;
	private final Random random = new Random();

	public ComputerPosition() {
		this.computerPosition = pickRandomPosition();
	}

	private List<Integer> pickRandomPosition() {
		return Arrays.stream(new List[Constant.POSITION_LENGTH])
			.map(num -> random.nextInt(Constant.END_RANGE) + Constant.START_RANGE)
			.collect(Collectors.toList());
	}

	public List<Integer> getComputerPosition() {
		return computerPosition;
	}
}
