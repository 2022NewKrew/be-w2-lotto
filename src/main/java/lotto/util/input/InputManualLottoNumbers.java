package lotto.util.input;

import lotto.util.TypeConverter;
import lotto.util.Validator;

import java.util.List;

public class InputManualLottoNumbers implements ConsoleInputInterface<List<Integer>>{

    @Override
    public String getMessage() {
        return "수동으로 구매할 번호를 입력해 주세요.";
    }

    @Override
    public List<Integer> convert(String inputString) {
        List<Integer> manualLottoNumbers = TypeConverter.strToIntegerList(inputString);
        Validator.checkLottoNumbersFormat(manualLottoNumbers);
        return manualLottoNumbers;
    }

}
