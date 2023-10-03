package penaltykick.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ComputerPosition {
	private static final int POSITION_LENGTH = 5;
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 3;
	private final List<Integer> computerPosition;
	private static Random random = new Random();

	public ComputerPosition() {
		this.computerPosition = createRandomPosition();
	}

	private List<Integer> createRandomPosition() {
		List<Integer> randomPosition = pickRandomPosition();
		System.out.println(randomPosition);
		return randomPosition;
	}

	private List<Integer> pickRandomPosition() {
		return Arrays.stream(new List[POSITION_LENGTH]).map(num -> random.nextInt())
			.collect(Collectors.toList());
	}

	public List<Integer> getComputerPosition() {
		return computerPosition;
	}
}
