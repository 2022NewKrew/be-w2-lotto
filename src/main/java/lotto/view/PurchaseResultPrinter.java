package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

import static lotto.LottoSimulator.SEPARATOR;

public class PurchaseResultPrinter {
    public static final String SPACE = " ";
    public static final String PREFIX = "[";
    public static final String SUFFIX = "]";

    public void printPurchaseResult(@NotNull PurchasedLotto purchasedLotto) {
        System.out.println(purchasedLotto.getNumPurchasedLotto() + "개를 구매했습니다.");
        purchasedLotto.getPurchasedLottos().forEach(this::printLotto);
    }

    private void printLotto(@NotNull Lotto lotto) {
        System.out.println(lotto.getDigits()
                .stream()
                .sorted()
                .map(digit -> Integer.toString(digit))
                .collect(Collectors.joining(SEPARATOR + SPACE, PREFIX, SUFFIX)));
    }
}
