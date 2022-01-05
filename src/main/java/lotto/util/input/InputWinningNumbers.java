package lotto.util.input;

import lotto.util.TypeConverter;
import lotto.util.Validator;

import java.util.List;

public class InputWinningNumbers implements ConsoleInputInterface<List<Integer>>{

    @Override
    public String getMessage() {
        return "지난 주 당첨 번호를 입력해 주세요.";
    }

    @Override
    public List<Integer> convert(String inputString) {
        List<Integer> winningNumbers = TypeConverter.strToIntegerList(inputString);
        Validator.checkLottoNumbersFormat(winningNumbers);
        return winningNumbers;
    }
}
