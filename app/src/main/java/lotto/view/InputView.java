package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinningNumber;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class InputView {
    private static final String MSG_INPUT_MONEY = "구매금액을 입력해 주세요.";
    private static final String MSG_INPUT_WINNING_NUMBERS = "지난주 당첨 번호를 입력해 주세요.";
    private static final String MSG_INPUT_BONUS = "보너스 볼을 입력해 주세요.";
    private static final String MSG_INPUT_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MSG_INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static Scanner scanner;
    private static boolean isCalled = false;

    private InputView() {
    }

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static int inputPurchasePrice() {
        final int purchase;

        System.out.println(MSG_INPUT_MONEY);
        purchase = scanner.nextInt();
        checkMoneyNotNegative(purchase);
        scanner.nextLine();
        return purchase;
    }

    public static LottoWinningNumber inputLastWinningNumbers() {
        System.out.println(MSG_INPUT_WINNING_NUMBERS);
        return new LottoWinningNumber(inputNumbers(), inputBonusBall());
    }

    public static List<LottoNumber> inputLottoNumbersManually() {
        if (!isCalled) {
            System.out.println(MSG_INPUT_MANUAL_LOTTO);
            isCalled = true;
        }
        return inputNumbers();
    }

    public static LottoNumber inputBonusBall() {
        final int bonusBall;

        System.out.println(MSG_INPUT_BONUS);

        bonusBall = scanner.nextInt();

        scanner.nextLine();
        return LottoNumber.from(bonusBall);
    }

    public static int inputManualLottoCount() {
        final int manualLottoCount;

        System.out.println(MSG_INPUT_MANUAL_COUNT);
        manualLottoCount = scanner.nextInt();
        checkCountNotNegative(manualLottoCount);

        scanner.nextLine();
        return manualLottoCount;
    }

    private static List<LottoNumber> inputNumbers() {
        List<LottoNumber> numbers = new ArrayList<>(Lotto.LENGTH);

        for (String s : scanner.nextLine().replaceAll(" ", "").split(",")) {
            numbers.add(LottoNumber.from(Integer.parseInt(s)));
        }
        return numbers;
    }

    private static void checkMoneyNotNegative(final int money) {
        if (money < 0)
            throw new InputMismatchException();
    }

    private static void checkCountNotNegative(final int count) {
        if (count < 0)
            throw new InputMismatchException();
    }
}
