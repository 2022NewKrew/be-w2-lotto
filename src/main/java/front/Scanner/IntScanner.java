package front.Scanner;

import exception.IllegalInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IntScanner {
    private static final Scanner sc = new Scanner(System.in);

    public static int getInt() {
        return parseInt(sc.nextLine());
    }

    private static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalInputException("정수형을 입력하세요.");
        }
    }

    public static List<Integer> getIntList() {
        String[] input = sc.nextLine().split(", ");
        return Arrays
                .stream(input)
                .map(IntScanner::parseInt)
                .collect(Collectors.toList());
    }
}
