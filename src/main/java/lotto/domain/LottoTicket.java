package lotto.domain;

import java.util.List;

public class LottoTicket {
    private List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
