package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers = new ArrayList<>();

    public LottoTicket(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers.addAll(numbers);
    }

    public int getSize() {
        return numbers.size();
    }

    public int getNumberOfMatched(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
