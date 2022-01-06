package lotto.view;

import lotto.domain.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오전 11:08
 */
public class LottoScanner {
    private static final Scanner scanner = new Scanner(System.in);

    private LottoScanner() {
        // instance 생성 제한
    }

    public static Integer getPurchaseAmount() {
        System.out.println(Constants.INPUT_PURCHASE_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> getLastWeekWinningNumbers() {
        System.out.println(Constants.INPUT_LAST_WEEK_MESSAGE);
        String lastWeekWinningNumber = scanner.nextLine();

        return Arrays.stream(lastWeekWinningNumber.split(Constants.INPUT_MANUAL_LOTTO_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer getBonusBall() {
        System.out.println(Constants.INPUT_BONUS_BALL_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static Integer getManualLottoCount() {
        System.out.println(Constants.INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> getManualLottoNumber() {
        String manualLottoNumbers = scanner.nextLine();

        return Arrays.stream(manualLottoNumbers.split(Constants.INPUT_MANUAL_LOTTO_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
