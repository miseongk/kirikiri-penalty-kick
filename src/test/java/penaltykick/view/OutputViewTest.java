package penaltykick.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import penaltykick.domain.GameResult;


class OutputViewTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    void 플레이어_1_우승_출력_확인() {
        List<Integer> comPos = List.of(2, 3, 3, 1, 3);
        List<Integer> playerOnePos = List.of(2, 3, 3, 1, 1);
        List<Integer> playerTwoPos = List.of(2, 3, 1, 2, 3);

        GameResult playerOneGameResult = new GameResult(comPos, playerOnePos);
        GameResult playerTwoGameResult = new GameResult(comPos, playerTwoPos);
        new OutputView(playerOneGameResult, playerTwoGameResult).printGameResult();

        String output = "플레이어1이(가) 우승했습니다🎉\n";

        assertEquals(output, outputMessage.toString());
    }

    @Test
    void 플레이어_2_우승_출력_확인() {
        List<Integer> comPos = List.of(2, 3, 3, 1, 3);
        List<Integer> playerOnePos = List.of(1, 3, 2, 2, 1);
        List<Integer> playerTwoPos = List.of(2, 3, 1, 2, 3);

        GameResult playerOneGameResult = new GameResult(comPos, playerOnePos);
        GameResult playerTwoGameResult = new GameResult(comPos, playerTwoPos);
        new OutputView(playerOneGameResult, playerTwoGameResult).printGameResult();

        String output = "플레이어2이(가) 우승했습니다🎉\n";

        assertEquals(output, outputMessage.toString());
    }

    @Test
    void 무승부_출력_확인() {
        List<Integer> comPos = List.of(2, 3, 3, 1, 3);
        List<Integer> playerOnePos = List.of(2, 3, 1, 2, 3);
        List<Integer> playerTwoPos = List.of(2, 3, 1, 2, 3);

        GameResult playerOneGameResult = new GameResult(comPos, playerOnePos);
        GameResult playerTwoGameResult = new GameResult(comPos, playerTwoPos);
        new OutputView(playerOneGameResult, playerTwoGameResult).printGameResult();

        String output = "무승부입니다.\n";

        assertEquals(output, outputMessage.toString());
    }
}
