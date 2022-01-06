package service.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private LottoResult result;

    protected Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.result = LottoResult.UNIDENTIFIED;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoResult getResult() {
        return result;
    }

    public int getPrizeMoney() {
        return result.getPrizeMoney();
    }

    public void confirmTheWin(List<Integer> winningNumbers, int bonusBall) {
        if (result != LottoResult.UNIDENTIFIED)
            return;

        this.result = LottoResult.of(
                (int) winningNumbers.stream()
                        .filter(numbers::contains)
                        .count() ,
                numbers.contains(bonusBall)
        );
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
