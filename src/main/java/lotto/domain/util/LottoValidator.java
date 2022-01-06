package lotto.domain.util;

import java.util.List;

import static lotto.domain.LottoInfo.*;

public class LottoValidator {
    public void validateLottoNumbers(List<Integer> lottoNumbers){
        if (lottoNumbers.size() != COUNT_OF_NUMBER.getValue()) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
        lottoNumbers.forEach(this::validateRange);
        validateDuplicate(lottoNumbers.size() != lottoNumbers.stream().distinct().count());
    }

    public void validateBonusBall(List<Integer> lottoNumbers, int bonusBall){
        validateRange(bonusBall);
        validateDuplicate(lottoNumbers.contains(bonusBall));
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("번호의 범위는 1~45 입니다.");
        }
    }

    private void validateDuplicate(boolean isInvalid) {
        if (isInvalid) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }
}