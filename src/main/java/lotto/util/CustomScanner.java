package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomScanner {
    private final Scanner scanner;

    public CustomScanner() {
        this.scanner = new Scanner(System.in);
    }

    public int getMoney() {
        String message = "구입금액을 입력해 주세요.";
        return readIntFromCli(message);
    }

    private int readIntFromCli(String message) {
        try {
            System.out.println(message);
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력할 수 있습니다.");
            return readIntFromCli(message);
        }
    }

    public List<Integer> getWinningNumbers() {
        String message = "지난 주 당첨 번호를 입력해 주세요.";
        return readCommaSeparatedIntFromCli(message);
    }

    private List<Integer> readCommaSeparatedIntFromCli(String message) {
        try {
            System.out.println(message);
            List<Integer> numbers = Arrays.stream(scanner.nextLine().split(","))
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList());
            numbers.forEach(number -> verifyBoundedInt(number));
            return numbers;
        } catch (NumberFormatException e) {
            System.out.println("숫자 값만 입력할 수 있습니다.");
            return readCommaSeparatedIntFromCli(message);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCommaSeparatedIntFromCli(message);
        }
    }

    private int verifyBoundedInt(int value) {
        if (1 > value || value > 45) {
            throw new IllegalArgumentException("1 이상 45 이하의 값을 입력해 주세요.");
        }
        return value;
    }
}
