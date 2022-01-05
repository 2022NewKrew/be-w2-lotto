package lotto.domain;

import lotto.domain.userinput.WinningLottoInput;
import lotto.domain.util.LottoValidator;

import java.util.List;

public class Lotto {
    private static final LottoValidator VALIDATOR = new LottoValidator();

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        VALIDATOR.validateLottoNumbers(numbers);
    }

    public LottoMatchResult countMatchedNumber(WinningLottoInput winningLottoInput) {
        int matchCount = (int) winningLottoInput.getWinningTicket().getNumbers().stream()
                .filter(numbers::contains).count();
        boolean isBonusBallMatched = numbers.contains(winningLottoInput.getBonusBall());
        return new LottoMatchResult(matchCount, isBonusBallMatched);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}