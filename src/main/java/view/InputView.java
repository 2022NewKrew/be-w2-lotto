package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_AMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTotalPrice() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        int totalPrice = scanner.nextInt();
        scanner.nextLine();
        return totalPrice;
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String inputString = scanner.nextLine();
        return inputString;
    }

    public static int inputManualAmount() {
        System.out.println(INPUT_MANUAL_AMOUNT_MESSAGE);
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static List<String> inputManualNumbers(int amount) {
        System.out.println(INPUT_MANUAL_NUMBER_MESSAGE);
        List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < amount; ++i) {
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;

    }
}

