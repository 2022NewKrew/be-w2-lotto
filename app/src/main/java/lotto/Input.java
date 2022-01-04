package lotto;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Input {
    private static final String MSG_INPUT_MONEY = "구매금액을 입력해 주세요.";
    private static final String MSG_INPUT_WINNING_NUMBERS = "지난주 당첨 번호를 입력해 주세요.";
    private static final String MSG_INPUT_BONUS = "보너스 볼을 입력해 주세요.";
    private static Scanner scanner;

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static int getMoney() {
        System.out.println(MSG_INPUT_MONEY);
        return scanner.nextInt();
    }

    public static List<Integer> getLastWinningNumbers() {
        List<Integer> lastWinningNumbers = new ArrayList<>(6);
        System.out.println(MSG_INPUT_WINNING_NUMBERS);
        scanner.nextLine();
        for(String s : scanner.nextLine().replaceAll(" ", "").split(",")) {
            lastWinningNumbers.add(Integer.parseInt(s));
        }
        return lastWinningNumbers;
    }

    public static Integer getBonusBall() {
        System.out.println(MSG_INPUT_BONUS);
        return scanner.nextInt();
    }
}
