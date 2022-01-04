package domain.lottery;

import java.util.List;

public class Result {
    private final List<Integer> numbers;
    private int bonusBall;

    public Result(List<Integer> numbers, NumbersFactory numbersFactory, int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호에 포함되면 안 됩니다.");
        }

        this.numbers = numbersFactory.getValidatedNumbers(numbers);
        this.bonusBall = bonusBall;
    }

    public int getMatchingCountOf(Ticket ticket) {
        int matchingCount = 0;
        for (var ticketNumber : ticket.getNumbers()) {
            matchingCount += numbers.contains(ticketNumber) ? 1 : 0;
        }
        return matchingCount;
    }

    public boolean isBonusBallMatched(Ticket ticket) {
        return ticket.getNumbers().contains(this.bonusBall);
    }
}
