package penaltykick.domain;

import penaltykick.Utils;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Integer> movePosition;

	public Player(String name, List<Integer> movePosition) {
		validate(movePosition);
		this.name = name;
		this.movePosition = movePosition;
	}

	private void validate(List<Integer> movePosition) {
		int validateCount = (int) movePosition.stream()
				.filter(position -> Utils.isInRange(0, 3, position))
				.count();
		if (validateCount != 5) {
			throw new IllegalArgumentException("숫자는 1~3 사이 숫자를 빈칸으로 구분하여 5번 입력해야합니다.");
		}
	}

	public String getName() {
		return this.name;
	}

	public List<Integer> getMovePosition() {
		return new ArrayList<>(movePosition);
	}
}
