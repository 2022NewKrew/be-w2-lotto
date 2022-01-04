package validator;

import constants.LottoRule;

public abstract class IntegerValidator {
    protected boolean isNumeric(String input){
        return !input.matches(LottoRule.IS_NUMERIC);
    }
}
