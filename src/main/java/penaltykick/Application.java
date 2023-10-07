package penaltykick;

import penaltykick.controller.PenaltyKickController;
import penaltykick.domain.PenaltyKickReferee;
import penaltykick.domain.RandomNumberGenerator;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		PenaltyKickController penaltyKickController = new PenaltyKickController(
			new PenaltyKickReferee(new RandomNumberGenerator()));
		penaltyKickController.run();
	}
}
