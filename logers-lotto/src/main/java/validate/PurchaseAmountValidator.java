package validate;

import domain.Lotto;

public class PurchaseAmountValidator extends Validator {
    @Override
    protected boolean supports(Object value) {
        return value instanceof Integer;
    }

    @Override
    public void validateValue(Object value) {
        Integer number = (Integer) value;
        if(number % Lotto.PRICE != 0){
            throw new IllegalArgumentException(
                    "로또 가격의 단위는 ".concat(String.valueOf(Lotto.PRICE)).concat("입니다."));
        }

        if(number <= 0){
            throw new IllegalArgumentException("구매 금액은 양수로 적어주세요.");
        }
    }
}
