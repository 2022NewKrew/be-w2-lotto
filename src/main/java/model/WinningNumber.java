package model;

import java.util.*;

public class WinningNumber {
    private final List<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<LottoNumber> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = new ArrayList<>(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validate(List<LottoNumber> numbers, int bonusNumber) {
        validateSixNumbers(numbers, bonusNumber);
        validateDuplicateNumbers(numbers, bonusNumber);
    }

    private void validateSixNumbers(List<LottoNumber> numbers, int bonusNumber) {
        int numberCount = numbers.size();
        if (bonusNumber >= 1 && bonusNumber <= 45) {
            numberCount++;
        }
        if (numberCount != 7) {
            throw new IllegalArgumentException("당첨번호에는 반드시 7개의 숫자가 들어가야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<LottoNumber> numbers, int bonusNumber) {
        Set<Integer> numberSets = new HashSet<>();
        for (LottoNumber lottoNumber : numbers) {
            numberSets.add(lottoNumber.getNumber());
        }
        numberSets.add(bonusNumber);

        if (numberSets.size() != 7) {
            throw new IllegalArgumentException("당첨번호에 중복된 번호를 넣을 수 없습니다.");
        }
    }

    public int compareLottoNumber(List<LottoNumber> lotto) {
        int correctNumberCount = 0;

        for (LottoNumber lottoNumber : numbers) {
            correctNumberCount += isContainedNumber(lotto, lottoNumber);
        }
        return correctNumberCount;
    }

    public boolean compareBonusLottoNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private int isContainedNumber(List<LottoNumber> lotto, LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
