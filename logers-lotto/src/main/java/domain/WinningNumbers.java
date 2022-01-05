package domain;

import java.util.List;

public class WinningNumbers {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.lottoNumbers = new LottoNumbers(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public RewardType matching(LottoNumbers otherLottoNumbers) {
        int matched = this.lottoNumbers.matchedBy(otherLottoNumbers);
        boolean isBonusMatched = otherLottoNumbers.contains(bonusNumber);
        return RewardType.of(matched, isBonusMatched);
    }

    private static void validate(List<Integer> numbers, int bonusNumber) {
        LottoNumbers.validate(numbers);
        LottoNumber.validate(bonusNumber);
        validateBonusNumberNotContained(numbers, bonusNumber);
    }

    private static void validateBonusNumberNotContained(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨번호들과 달라야 합니다.");
        }
    }
}
