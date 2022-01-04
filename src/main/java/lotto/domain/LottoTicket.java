package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoTicket {
    private final Set<Integer> numbers;

    public LottoTicket(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchWithWinnerNumber(Set<Integer> winnerNumber) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(winnerNumber);
        return intersection.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
