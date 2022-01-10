package lottogame.domain;

import lottogame.exception.ErrorMessage;
import lottogame.exception.LotteryGameException;

import java.util.ArrayList;
import java.util.List;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        validateInsufficientAmount(amount);
        this.amount = amount;
    }

    public Amount(Price purchasePrice, Price defaultPrice) {
        this(purchasePrice.calculateAmount(defaultPrice));
    }

    private void validateInsufficientAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new LotteryGameException(ErrorMessage.UNDER_MIN_AMOUNT);
        }
    }

    public LotteryTickets buyLotteryTickets(LotteryNumbersGenerator lotteryNumbersGenerator) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lotteryTickets.add(new LotteryTicket(lotteryNumbersGenerator.generate()));
        }
        return new LotteryTickets(lotteryTickets);
    }

    public int getAmount() {
        return amount;
    }

    public Amount subtract(Amount manualAmount) {
        return new Amount(amount - manualAmount.amount);
    }
}