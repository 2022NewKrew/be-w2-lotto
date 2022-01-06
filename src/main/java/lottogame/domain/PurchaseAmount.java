package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseAmount {
    private static final int MIN_PRICE = 1;
    private static final int DEFAULT_PRICE = 1000;

    private int purchaseAmount;
    private int count;

    public PurchaseAmount(int purchaseAmount) {
        validateUpperMinPrice(purchaseAmount);
        validateInsufficientAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        count = purchaseAmount / DEFAULT_PRICE;
    }

    private void validateUpperMinPrice(int purchaseAmount) {
        if (purchaseAmount < MIN_PRICE) {
            throw new IllegalArgumentException("구입금액은 0보다 커야합니다.");
        }
    }

    private void validateInsufficientAmount(int purchaseAmount) {
        if (purchaseAmount % DEFAULT_PRICE != 0) {
            throw new IllegalArgumentException("구입금액이 부족합니다.");
        }
    }

    public LotteryTickets buyLotteryTickets(RandomGenerator randomNumbersGenerator) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteryTickets.add(new LotteryTicket(randomNumbersGenerator.generate()));
        }
        return new LotteryTickets(lotteryTickets);
    }

    public int calculateRateOfReturn(int prizeMoney) {
        return ((int) ((double) (prizeMoney / purchaseAmount)) * 100) - 100;
    }
}
