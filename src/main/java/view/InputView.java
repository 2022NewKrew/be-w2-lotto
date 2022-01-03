package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_PURCHASE_AMOUNT_LOTTO = "개를 구입했습니다.";
    //    private static final String INPUT_LOTTO_MANUAL_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
//    private static final String INPUT_LOTTO_AUTO_NUMBER = "자동으로 구매할 로또 수를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int purchasedLottoNumbers = scanner.nextInt() / 1000;
        System.out.println(purchasedLottoNumbers + INPUT_PURCHASE_AMOUNT_LOTTO);
        return purchasedLottoNumbers;
    }
}
