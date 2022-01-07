package view;

import domain.Lotto;
import domain.LottoWinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final int LOTTO_COST = 1000;
    private static final String INPUT_PURCHASE_AMOUNT_LOTTO = "개를 구입했습니다.";
    //    private static final String INPUT_LOTTO_MANUAL_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
//    private static final String INPUT_LOTTO_AUTO_NUMBER = "자동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WIN_NUMBER = "지난 주 당험 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int purchasedLottoNumbers = scanner.nextInt();
        System.out.println(purchasedLottoNumbers/LOTTO_COST + INPUT_PURCHASE_AMOUNT_LOTTO);
        return purchasedLottoNumbers;
    }

    public static Lotto lastWeekNumbers() {
        System.out.println(INPUT_LAST_WEEK_WIN_NUMBER);
        String numbersBeforeDefined = scanner.next();
        Set<Integer> numbersAfterDefined = Arrays.stream(numbersBeforeDefined.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        return new Lotto(numbersAfterDefined);
    }

    public static LottoWinningNumber bonusNumber() {
        Lotto withoutBonus = lastWeekNumbers();
        System.out.println(INPUT_BONUS_NUMBER);
        int bonus = scanner.nextInt();
        return new LottoWinningNumber(withoutBonus.getLotto(), bonus);
    }
}
