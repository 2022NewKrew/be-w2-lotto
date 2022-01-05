package view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_PURCHASING_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_LOTTO_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_LOTTO_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {}

    public static String enterPurchasingAmount() {
        System.out.println(MESSAGE_PURCHASING_AMOUNT);
        return scanner.next();
    }

    public static String enterWinningNumbers() {
        System.out.println(MESSAGE_WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static String enterBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);
        return scanner.nextLine().trim();
    }

    public static void messageLottoManualCount() {
        System.out.println();
        System.out.println(MESSAGE_LOTTO_MANUAL_NUMBERS);
    }

    public static String enterLottoManualCount() {
        scanner.nextLine();
        System.out.println();
        System.out.println(MESSAGE_LOTTO_MANUAL_COUNT);
        return scanner.nextLine();
    }

    public static String enterLottoManualNumbers() {
        return scanner.nextLine();
    }
}
