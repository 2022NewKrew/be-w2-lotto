package view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final String MESSAGE_PURCHASING_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER_COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_LOTTO_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ILLEGAL_LOTTO = "로또는 6개의 서로 다른 숫자로 만들어져야 합니다";
    private static final String MESSAGE_CHECK_NUMERIC = "구매할 로또 수는 0이상의 정수여야 합니다.";
    private static final String NUMERIC_REGEX = "^[0-9]+$";
    private static final Pattern PATTERN_NUMERIC = Pattern.compile(NUMERIC_REGEX);
    private static final int LOTTO_SIZE = 6;

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

    public static long enterLottoManualCount() {
        scanner.nextLine();
        System.out.println();
        System.out.println(MESSAGE_LOTTO_MANUAL_COUNT);
        String input = scanner.nextLine();
        checkNumeric(input);
        return Long.parseLong(input);
    }

    public static String[] enterLottoManualNumbers() {
        String[] lottoNumbers = scanner.nextLine().split(DELIMITER_COMMA);
        validateLottoSize(lottoNumbers);
        lottoNumbers = Arrays.stream(lottoNumbers)
                .map(String::trim)
                .toArray(String[]::new);
        return lottoNumbers;
    }

    private static void validateLottoSize(String[] lottoNumbers) {
        if (lottoNumbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO);
        }
    }

    private static int checkNumeric(String number) {
        number = number.trim();
        if (!PATTERN_NUMERIC.matcher(number).matches()) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NUMERIC);
        }
        return Integer.parseInt(number);
    }
}
