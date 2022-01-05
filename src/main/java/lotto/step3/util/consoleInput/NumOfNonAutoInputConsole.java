package lotto.step3.util.consoleInput;


import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step1.util.consoleInput.InputConsole;

public class NumOfNonAutoInputConsole implements InputConsole<Integer> {

    @Override
    public String getMsg() {
        return "수동으로 구매할 로또 수를 입력해 주세요.";
    }

    @Override
    public Integer convert(String inputStr) {
        return TypeConverter.strToInt(inputStr, Validator.EMPTY_VALIDATOR);
    }
}
