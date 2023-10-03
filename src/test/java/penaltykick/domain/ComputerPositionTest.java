package penaltykick.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ComputerPositionTest {

	@Test
	void 서로다른_임의의_수_다섯_개_생성() {
		List<Integer> result = new ComputerPosition().getComputerPosition();
		assertEquals(5, result.size());
	}
}