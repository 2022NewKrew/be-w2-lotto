package model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket extends BaseEntity {
    private final List<Integer> numbers;
    private LottoResult result;

    protected LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
        this.result = LottoResult.UNIDENTIFIED;
    }

    protected void calcResult(List<Integer> winningNumbers, Integer bonusNumber) {
        int matchNumber = getMatchNumberWithWinningNumbers(winningNumbers);
        boolean includeBonus = numbers.contains(bonusNumber);
        result = LottoResult.of(matchNumber, includeBonus);
    }

    private int getMatchNumberWithWinningNumbers(List<Integer> winningNumbers) {
        return (int) numbers
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public LottoResult getResult() {
        return result;
    }

    public String convertTicketToString() {
        String result =
                numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));

        return "[" + result + "]";
    }
}
