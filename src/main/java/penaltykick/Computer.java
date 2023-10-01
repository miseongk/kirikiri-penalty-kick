package penaltykick;

import java.util.List;

public class Computer {

	private static final int REPEAT_NUMBER = 5;

	private final List<Integer> locations;

	public Computer(List<Integer> locations) {
		this.locations = locations;
	}

	public void generateRandomNumber(int number) {
		for (int i = 0; i < REPEAT_NUMBER; i++) {
			locations.add(number);
		}
	}
}
