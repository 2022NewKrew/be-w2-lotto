package lotto.domain;

public class LottoPrice {

    private static final int LOTTO_PRICE = 1000;

    private LottoPrice() {
        throw new AssertionError();
    }

    public static int calculateLottoPurchaseCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public static int calculateLottoPurchaseAmount(int purchaseCount) {
        return purchaseCount * LOTTO_PRICE;
    }
}
