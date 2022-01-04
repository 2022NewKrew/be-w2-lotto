package domain.lottery;

import java.util.List;

public class Result {
    private final List<Integer> numbers;
    private final int bonusBall;

    public Result(List<Integer> numbers, NumbersFactory numbersFactory, int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호에 포함되면 안 됩니다.");
        }

        this.numbers = numbersFactory.getValidatedNumbers(numbers);
        this.bonusBall = bonusBall;
    }

    public int getMatchingCountOf(Ticket ticket) {
        return (int) numbers.stream().filter(number -> ticket.contains(number)).count();
    }

    public boolean isBonusBallMatched(Ticket ticket) {
        return ticket.contains(this.bonusBall);
    }
}
