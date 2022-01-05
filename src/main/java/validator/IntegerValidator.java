package validator;

import constants.LottoRule;
import exception.LottoException;

public abstract class IntegerValidator {
    protected void isNumeric(String input) throws LottoException {
        if (!input.matches(LottoRule.IS_NUMERIC)) {
            throw new LottoException("정수로 입력해주세요.");
        }
    }
}
