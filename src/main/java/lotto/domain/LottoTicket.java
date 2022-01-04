package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoTicket {
    private final Set<Integer> numbers;

    public LottoTicket(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Prize matchWithWinnerNumber(Set<Integer> winnerNumber, int bonusBall) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(winnerNumber);

        int matchedCount = intersection.size();
        boolean bonusBallMatched = numbers.contains(bonusBall);

        return Prize.getPrize(matchedCount, bonusBallMatched);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
