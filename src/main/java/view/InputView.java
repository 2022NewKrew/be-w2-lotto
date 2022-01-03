package view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_PURCHASING_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER_COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String enterPurchasingAmount() {
        System.out.println(MESSAGE_PURCHASING_AMOUNT);
        return scanner.next();
    }

    public static String[] enterWinningNumbers() {
        System.out.println(MESSAGE_WINNING_NUMBER);
        scanner.nextLine();
        return scanner.nextLine().trim().split(DELIMITER_COMMA);
    }

    public static String enterBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);
        return scanner.nextLine().trim();
    }
}
