package domain.lottery;

import java.util.List;

public class Ticket {
    private final List<Integer> numbers;

    public Ticket(NumbersFactory numbersFactory) {
        this.numbers = numbersFactory.getRandomNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
