package lotto.step1.model;

import java.util.List;
import java.util.stream.Collectors;


public class LottoNumbers extends BaseEntity {
    protected final List<Integer> numbers;
    protected LottoResult result;

    protected LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        this.result = LottoResult.UNIDENTIFIED;
    }

    protected LottoNumbers(List<Integer> numbers, LottoResult result) {
        this.numbers = numbers;
        this.result = result;
    }

    public LottoResult getResult() {
        return result;
    }

    public void confirmTheWin(List<Integer> winningNumbers) {
        if (result != LottoResult.UNIDENTIFIED)
            return;

        final int score = (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();

        result = LottoResult.of(score);
    }

    public int getPrizeMoney() {
        return result.getPrizeMoney();
    }

    @Override
    public String toString() {
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        return "[" + result + "]";
    }
}
