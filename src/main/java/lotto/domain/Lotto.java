package lotto.domain;

import lotto.domain.util.LottoValidator;

import java.util.List;

public class Lotto {
    private static final LottoValidator VALIDATOR = new LottoValidator();

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        VALIDATOR.validateLottoNumbers(numbers);
    }

    public LottoMatchDto countMatchedNumber(Lotto winningTicket, int bonusBall) {
        int matchCount = (int) winningTicket.getNumbers().stream()
                .filter(numbers::contains).count();
        boolean isBonusBallMatched = numbers.contains(bonusBall);
        return new LottoMatchDto(matchCount, isBonusBallMatched);
    }

    public void validateWithBonusBall(int bonusBall){
        VALIDATOR.validateBonusBall(numbers, bonusBall);
    }

    private List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}