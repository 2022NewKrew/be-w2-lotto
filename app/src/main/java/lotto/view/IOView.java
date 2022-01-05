package lotto.view;

import lotto.util.StringParsingUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public final class IOView {

    private IOView() {
    }

    public static int inputToInt(String message, Scanner scanner) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static List<List<Integer>> inputToDoubleList(String message, Scanner scanner, int iterableCount) {
        System.out.println(message);
        List<List<Integer>> inputList = new ArrayList<>();
        for (int i = 0; i < iterableCount; i++) {
            inputList.add(StringParsingUtil.parse(scanner.nextLine(), ",").stream()
                    .map(Integer::parseInt)
                    .collect(toList()));
        }
        return inputList;
    }

    public static List<Integer> inputToList(String message, Scanner scanner) {
        System.out.println(message);
        return StringParsingUtil.parse(scanner.nextLine(), ",").stream()
                .map(Integer::parseInt)
                .collect(toList());
    }
}
