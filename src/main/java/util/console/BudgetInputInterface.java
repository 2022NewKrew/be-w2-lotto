package util.console;

import util.TypeConverter;
import util.Validator;

public class BudgetInputInterface implements InputInterface<Integer> {
    @Override
    public String getMsg() {
        return "구입금액을 입력해 주세요.";
    }

    @Override
    public Integer convert(String inputString) {
        return TypeConverter.convertStringToInteger(inputString, Validator.INTEGER_GREATER_THAN_OR_EQUAL_TO_1000);
    }
}
