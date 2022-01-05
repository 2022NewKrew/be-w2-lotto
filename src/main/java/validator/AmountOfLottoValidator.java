package validator;

import constants.LottoRule;
import exception.LottoException;

public class AmountOfLottoValidator extends IntegerValidator implements ValidatorInterface {
    public AmountOfLottoValidator() {
    }

    @Override
    public void validateData(String input) throws LottoException {
        isNumeric(input);
        dividableByThousand(input);
    }

    private void dividableByThousand(String input) throws LottoException {
        int intInput = Integer.parseInt(input);
        if (!(intInput >= 1000 && intInput % LottoRule.PRICE_PER_LOTTO == 0)) {
            throw new LottoException("로또는 1개에 1000원입니다.");
        }
    }
}
