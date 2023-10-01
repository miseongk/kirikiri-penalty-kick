package penaltykick;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int RANDOM_MIN_NUMBER = 1;
	private static final int RANDOM_MAX_NUMBER = 3;

	private final Random random = new Random();

	@Override
	public int generate() {
		return random.nextInt(RANDOM_MAX_NUMBER) + RANDOM_MIN_NUMBER;
	}
}
