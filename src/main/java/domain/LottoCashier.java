package domain;

import exception.InvalidPurchaseAmount;

import java.util.Map;

public class LottoCashier {
    private static final int MINIMUM_PURCHASE_AMOUNT = 1;
    private static final int MAXIMUM_PURCHASE_AMOUNT = 100;
    private static final int LOTTO_PRICE = 1000;

    public int buyLottos(int purchasedAmount) {
        validatePurchaseAmount(purchasedAmount);
        return purchasedAmount / LOTTO_PRICE;
    }

    public double getProfitRate(LottoRankMatch lottoRankMatch, int purchasedAmount) {
        double profit = 0.0;
        for (Map.Entry<LottoRank, Integer> resultIndex : lottoRankMatch.getLottoResult().entrySet()) {
            profit += (resultIndex.getKey().getMoney() * resultIndex.getValue());
//            System.out.println(resultIndex.getKey().getMessage() + resultIndex.getValue() + "개");
        }
        return (profit - purchasedAmount) / (purchasedAmount * 100);
    }

    private static void validatePurchaseAmount(int purchasedAmount) {
        if ((purchasedAmount/LOTTO_PRICE) < MINIMUM_PURCHASE_AMOUNT) {
            throw new InvalidPurchaseAmount(InvalidPurchaseAmount.MINIMUM_PURCHASE_AMOUNT);
        }
        if ((purchasedAmount / LOTTO_PRICE) > MAXIMUM_PURCHASE_AMOUNT) {
            throw new InvalidPurchaseAmount(InvalidPurchaseAmount.MAXIMUM_PURCHASE_AMOUNT);
        }
    }
}
