package lotto;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Input {
    private static final String MSG_INPUT_MONEY = "구매금액을 입력해 주세요.";
    private static final String MSG_INPUT_WINNING_NUMBERS = "지난주 당첨 번호를 입력해 주세요.";
    private static Scanner scanner;

    public static final void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static final void closeScanner() {
        scanner.close();
    }

    public static final int getMoney() {
        System.out.println(MSG_INPUT_MONEY);
        return scanner.nextInt();
    }

    public static final List<Integer> getLastWinningNumbers() {
        List<Integer> lastWinningNumbers = new ArrayList<>(6);
        System.out.println(MSG_INPUT_WINNING_NUMBERS);
        for(String s : scanner.next().split(",")) {
            lastWinningNumbers.add(Integer.parseInt(s));
        }
        return lastWinningNumbers;
    }
}
