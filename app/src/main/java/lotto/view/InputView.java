package lotto.view;

import lotto.domain.Lotto;

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
    private static final int NUMBER_MAX = 45;
    private static final int NUMBER_MIN = 1;
    private static final int LOTTO_NUMBERS_COUNT = 6; // 로또 숫자 6개
    private static Scanner scanner;

    private InputView() {
    }

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static int getPurchaseAmount() {
        final int purchase;

        System.out.println(MSG_INPUT_MONEY);
        purchase = scanner.nextInt();
        checkMoney(purchase);

        scanner.nextLine();
        return purchase;
    }

    public static List<Integer> getLastWinningNumbers() {
        System.out.println(MSG_INPUT_WINNING_NUMBERS);
        return getNumbers();
    }

    public static void getLottoNumbersManually(final List<Lotto> lottoList) {
        final int lottoCount = getManualLottoCount();

        System.out.println(MSG_INPUT_MANUAL_LOTTO);
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = getNumbers();
            lottoList.add(new Lotto(numbers));
        }
    }

    public static Integer getBonusBall() {
        final int bonusBall;

        System.out.println(MSG_INPUT_BONUS);

        bonusBall = scanner.nextInt();
        checkOneNumber(bonusBall);

        scanner.nextLine();
        return bonusBall;
    }

    private static int getManualLottoCount() {
        final int manualLottoCount;

        System.out.println(MSG_INPUT_MANUAL_COUNT);
        manualLottoCount = scanner.nextInt();
        checkCount(manualLottoCount);

        scanner.nextLine();
        return manualLottoCount;
    }

    private static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBERS_COUNT);

        for(String s : scanner.nextLine().replaceAll(" ", "").split(",")) {
            numbers.add(Integer.parseInt(s));
        }
        checkNumbers(numbers);
        return numbers;
    }

    private static void checkMoney(final int money) {
        if(money < 0)
            throw new InputMismatchException();
    }

    private static void checkCount(final int count) {
        if(count < 0)
            throw new InputMismatchException();
    }

    private static void checkOneNumber(final int number) {
        if(number < NUMBER_MIN || number > NUMBER_MAX)
            throw new InputMismatchException();
    }

    private static void checkNumbers(final List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBERS_COUNT)
            throw new InputMismatchException();

        for(Integer number : numbers) {
            checkOneNumber(number);
        }
    }
}
