package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoTicket {
    private final Set<Integer> numbers;

    public LottoTicket(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * @param winnerNumber 1등 번호
     * @param bonusBall 보너스 숫자
     * @return {@link LottoTicket#numbers}가 해당되는 {@link Prize}
     */
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
