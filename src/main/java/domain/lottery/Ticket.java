package domain.lottery;

import java.util.List;
import java.util.Random;

public class Ticket {
    private final Numbers numbersObject;

    public Ticket(List<Integer> numbers) {
        this.numbersObject = new Numbers(numbers);
    }

    public Ticket(Random random) {
        this.numbersObject = new Numbers(random);
    }

    public List<Integer> getNumbers() {
        return numbersObject.getNumbers();
    }
}
