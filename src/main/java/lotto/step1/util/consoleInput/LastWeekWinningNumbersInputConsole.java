package lotto.step1.util.consoleInput;


import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;

import java.util.List;

public class LastWeekWinningNumbersInputConsole implements InputConsole<List<Integer>> {

    @Override
    public String getMsg() {
        return "지난 주 당첨 번호를 입력해 주세요.";
    }

    @Override
    public List<Integer> convert(String inputStr) {
        return TypeConverter.strToIntList(inputStr, Validator.FROM_1_TO_45_VALIDATOR);
    }
}
