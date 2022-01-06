package lotto.step1.util.consoleInput;


import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;

public class PurchaseAmountInputConsole implements InputConsole<Integer> {

    @Override
    public String getMsg() {
        return "구입 금액을 입력해 주세요.";
    }

    @Override
    public Integer convert(String inputStr) {
        return TypeConverter.strToInt(inputStr, Validator.GREATER_THAN_1000);
    }
}
