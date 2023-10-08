package penaltykick;

import java.util.ArrayList;

public class GoalKeeper {
	// 컴퓨터 랜덤 숫자 만드는 메소드
	public ArrayList<Integer> computerRandomNumberGenerator(int count) {
		ArrayList<Integer> computerNumberList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			addRandomNumToList(computerNumberList);
		}
		return computerNumberList;
	}

	public void addRandomNumToList(ArrayList<Integer> computerNumberList) {
		int randomVal = (int) (Math.random() * 3 + 1);
		computerNumberList.add(randomVal);
	}
}

