package domain.lottery;

import java.util.List;

public class Result {
    private final List<Integer> numbers;

    public Result(List<Integer> numbers, NumbersFactory numbersFactory) {
        this.numbers = numbersFactory.getValidatedNumbers(numbers);
    }

    public int getMatchingCountOf(Ticket ticket) {
        int matchingCount = 0;
        for (var ticketNumber : ticket.getNumbers()) {
            matchingCount += numbers.contains(ticketNumber) ? 1 : 0;
        }
        return matchingCount;
    }
}
