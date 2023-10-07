package penaltykick.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public List<Integer> readPenaltyKickPosition(int playerNum) {
        System.out.print("플레이어" + playerNum + " : ");
        String inputString = scanner.nextLine();
        validatePenaltyKickPosition(inputString);

        return parseToIntegerList(inputString);
    }

    private void validatePenaltyKickPosition(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString);

        for (int i = 0; i < 5; i++) {
            if (!st.hasMoreTokens()) {
                throw new IllegalArgumentException();
            }

            try {
                Integer.parseInt(st.nextToken());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        if (st.hasMoreTokens()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> parseToIntegerList(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString);
        List<Integer> IntegerList = new ArrayList<>();

        while (st.hasMoreTokens()) {
            IntegerList.add(Integer.parseInt(st.nextToken()));
        }

        return IntegerList;
    }
}
