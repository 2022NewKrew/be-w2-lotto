package util.console.input;

import util.TypeConverter;
import util.Validator;

public class ManualInputInterface implements InputInterface<Integer> {
    @Override
    public String getMsg() {
        return "수동으로 구매할 로또 수를 입력해 주세요.";
    }

    @Override
    public Integer convert(String inputString) {
        return TypeConverter.convertStringToInteger(inputString, Validator.INTEGER_NOT_NEGATIVE_NUMBER);
    }
}
