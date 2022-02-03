package domain.validator;

import exception.LottoException;

public abstract class IntegerValidator {
    protected void isNumeric(String input) throws LottoException {
        try {
            int num = Integer.parseInt(input);
        } catch (Exception e) {
            throw new LottoException("정수로 입력해주세요.");
        }
    }
}
