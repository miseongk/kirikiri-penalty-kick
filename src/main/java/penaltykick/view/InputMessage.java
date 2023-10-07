package penaltykick.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputMessage {
    public static ArrayList<String> inputNumber() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        ArrayList<String> inputArrayList = new ArrayList(Arrays.asList(inputArray)); // string[] -> ArrayList<String>

        return inputArrayList;

    }
}
