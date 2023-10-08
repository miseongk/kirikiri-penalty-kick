package penaltykick.domain;

import java.util.List;

public class PenaltyKickReferee {

	public long resultCount(List<Boolean> results) {
		return results.stream()
			.filter(result -> result.equals(true))
			.count();
	}
}
