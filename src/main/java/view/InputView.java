package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_PURCHASE_AMOUNT_LOTTO = "개를 구입했습니다.";
    //    private static final String INPUT_LOTTO_MANUAL_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
//    private static final String INPUT_LOTTO_AUTO_NUMBER = "자동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WIN_NUMBER = "지난 주 당험 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int purchasedLottoNumbers = scanner.nextInt() / 1000;
        System.out.println(purchasedLottoNumbers + INPUT_PURCHASE_AMOUNT_LOTTO);
        return purchasedLottoNumbers;
    }

    public static List<Integer> numbers() {
        System.out.println(INPUT_LAST_WEEK_WIN_NUMBER);
        String numberBeforeDefined = scanner.next();
        return Arrays.stream(numberBeforeDefined.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
