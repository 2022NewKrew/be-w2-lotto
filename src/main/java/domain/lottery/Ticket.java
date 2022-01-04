package domain.lottery;

import java.util.List;
import java.util.Random;

public class Ticket {
    private final List<Integer> numbers;

    public Ticket(Random random, NumbersFactory numbersFactory) {
        this.numbers = numbersFactory.getRandomNumbers(random);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
