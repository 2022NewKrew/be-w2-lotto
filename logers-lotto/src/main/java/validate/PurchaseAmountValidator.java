package validate;

import domain.Lotto;

public class PurchaseAmountValidator extends Validator {
    @Override
    protected boolean supports(Object param) {
        return param instanceof Integer;
    }

    @Override
    protected void validateValue(Object param) throws IllegalArgumentException {
        Integer price = (Integer) param;

        if(price % Lotto.PRICE != 0){
            throw new IllegalArgumentException(
                    "로또 가격의 단위는 ".concat(String.valueOf(Lotto.PRICE)).concat("입니다."));
        }

        if(price <= 0){
            throw new IllegalArgumentException("구매 금액은 양수로 적어주세요.");
        }
    }
}
