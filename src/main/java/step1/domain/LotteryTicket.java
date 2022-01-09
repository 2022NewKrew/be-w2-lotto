package step1.domain;

import java.util.Collections;
import java.util.List;

public class LotteryTicket {

    private final List<Integer> numbers;

    LotteryTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbersData() {
        return Collections.unmodifiableList(numbers);
    }
}
