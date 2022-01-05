package validator;

import constants.LottoRule;
import exception.LottoException;

import java.util.List;

public class BonusValidator extends IntegerValidator implements ValidatorInterface {
    private final List<Integer> winningNumbers;

    public BonusValidator(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validateData(String input) throws LottoException {
        isNumeric(input);
        int bonus = Integer.parseInt(input);
        validateBoundary(bonus);
        isDuplicated(bonus);
    }

    private void validateBoundary(int bonus) throws LottoException {
        if (!(bonus <= LottoRule.MAX_LOTTO_NUMBER && bonus >= LottoRule.MIN_LOTTO_NUMBER)) {
            throw new LottoException("1에서 45사이로 입력해주세요.");
        }
    }

    private void isDuplicated(int bonus) throws LottoException {
        if (winningNumbers.contains(bonus)) {
            throw new LottoException("이미 존재하는 번호입니다.");
        }
    }
}
