package domain.lottery;

import java.util.List;

public class Result {
    private Numbers numbersObject;

    public Result(List<Integer> numbers) {
        this.numbersObject = new Numbers(numbers);
    }

    public int getMatchingCountOf(Ticket ticket) {
        int matchingCount = 0;
        for (var number : ticket.getNumbers()) {
            matchingCount += numbersObject.numbers.contains(number) ? 1 : 0;
        }
        return matchingCount;
    }
}
