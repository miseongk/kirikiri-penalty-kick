package penaltykick;

import penaltykick.domain.Keeper;
import penaltykick.domain.Player;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameService {

	public Player getWinner(Keeper computer, Player player1, Player player2) {
		int player1WinCount = getWinCount(computer, player1);
		int player2WinCount = getWinCount(computer, player2);
		if (player1WinCount < player2WinCount) return player2;
		if (player1WinCount > player2WinCount) return player1;
		return null;
	}

	private int getWinCount(Keeper computer, Player player) {
		List<Boolean> playerResult = getKickResult(computer, player);
		return (int) playerResult.stream()
				.filter(isSamePosition -> !isSamePosition)
				.count();
	}

	public List<Boolean> getKickResult(Keeper keeper, Player player) {
		List<Integer> keeperMovePosition = keeper.getMovePosition();
		List<Integer> playerMovePosition = player.getMovePosition();
		return IntStream.range(0, keeperMovePosition.size())
				.mapToObj(i -> Objects.equals(keeperMovePosition.get(i), playerMovePosition.get(i)))
				.collect(Collectors.toList());
	}
}
