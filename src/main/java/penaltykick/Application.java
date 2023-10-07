package penaltykick;

import penaltykick.controller.PenaltyKickController;
import penaltykick.domain.PenaltyKickReferee;
import penaltykick.domain.RandomNumberGenerator;

public class Application {

	public static void main(String[] args) {
		PenaltyKickController penaltyKickController = new PenaltyKickController(
			new PenaltyKickReferee(new RandomNumberGenerator()));
		penaltyKickController.run();
	}
}
