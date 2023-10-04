package penaltykick.domain;

import penaltykick.Utils;

import java.util.ArrayList;
import java.util.List;

public class Keeper {
	private List<Integer> movePosition;

	public Keeper(List<Integer> movePosition) {
		validate(movePosition);
		this.movePosition = movePosition;
	}

	private void validate(List<Integer> movePosition) {
		int validateCount = (int) movePosition.stream()
				.filter(position -> Utils.isInRange(0, 3, position))
				.count();
		if (validateCount != 5) {
			throw new IllegalArgumentException("숫자는 1~3 사이가 5번 입력해야합니다.");
		}
	}

	public List<Integer> getMovePosition() {
		return new ArrayList<>(movePosition);
	}
}
