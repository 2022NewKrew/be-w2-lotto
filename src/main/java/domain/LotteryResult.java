package domain;

import domain.util.LotteryNumbersValidator;

import java.util.ArrayList;
import java.util.List;

public class LotteryResult {
    private final List<Integer> numbers;
    private final int bonusBall;

    public LotteryResult(List<Integer> numbers, int bonusBall) {
        LotteryNumbersValidator.validate(numbers, bonusBall);

        // For numbers are meant to be private
        this.numbers = new ArrayList<>(numbers);
        this.bonusBall = bonusBall;
    }

    public int getMatchingCountOf(LotteryTicket lotteryTicket) {
        return (int) numbers.stream().filter(lotteryTicket::contains).count();
    }

    public boolean isBonusBallMatched(LotteryTicket lotteryTicket) {
        return lotteryTicket.contains(this.bonusBall);
    }
}
