package lotto.step3.util.consoleInput;


import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step1.util.consoleInput.InputConsole;

import java.util.List;

public class LottoNumbersListNoMsgInputConsole implements InputConsole<List<Integer>> {

    @Override
    public String getMsg() {
        return "";
    }

    @Override
    public List<Integer> convert(String inputStr) {
        return TypeConverter.strToIntList(inputStr, Validator.FROM_1_TO_45_VALIDATOR);
    }
}
