package penaltykick.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ComputerPositionTest {

	@Test
	void 숫자_길이_확인() {
		List<Integer> result = new ComputerPosition().getComputerPosition();
		assertEquals(5, result.size());
	}

	@Test
	void 숫자_범위_확인() {
		List<Integer> result = new ComputerPosition().getComputerPosition();
		assertTrue(result.stream().allMatch(num -> 1 <= num && num <= 3));
	}
}