package domain.validator;

import exception.LottoException;

public class MoneyValidator extends IntegerValidator implements Validator {
    @Override
    public void validate(String input) throws LottoException {
        this.isNumeric(input);

        int money = Integer.parseInt(input);
        if (money < 1000) {
            throw new LottoException("로또 구매 최소 금액은 1000원입니다.");
        }
    }
}
