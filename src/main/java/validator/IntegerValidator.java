package validator;

import constants.LottoRule;

public abstract class IntegerValidator {
    protected boolean isNumeric(String input){
        if(!input.matches(LottoRule.IS_NUMERIC)) {
            System.out.println("정수로 입력해주세요.");
            return false;
        }
        return true;
    }
}
