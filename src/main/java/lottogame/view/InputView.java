package lottogame.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputString() {
        return scanner.nextLine();
    }

    public static Integer inputInteger() {
        String input = inputString();
        return Integer.parseInt(input);
    }

    public static List<String> inputStrings(String delimiter) {
        String input = inputString();
        return Arrays.asList(input.split(delimiter));
    }

    public static List<Integer> inputIntegers(String delimiter) {
        List<String> inputStrings = inputStrings(delimiter);
        List<Integer> integers = new ArrayList<>();
        for (var inputString : inputStrings) {
            Integer value = Integer.parseInt(inputString);
            integers.add(value);
        }
        return integers;
    }
}
