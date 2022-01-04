package lotto.step2.util.consoleInput;


import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step1.util.consoleInput.InputConsole;

public class BonusBallInputConsole implements InputConsole<Integer> {

    @Override
    public String getMsg() {
        return "보너스 볼을 입력해 주세요.";
    }

    @Override
    public Integer convert(String inputStr) {
        return TypeConverter.strToInt(inputStr, Validator.FROM_1_TO_45_VALIDATOR);
    }
}
