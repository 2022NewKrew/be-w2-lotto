package util.console.input;

import util.TypeConverter;
import util.Validator;

public class BonusNumberInputInterface implements InputInterface<Integer> {
    @Override
    public String getMsg() {
        return "보너스 볼을 입력해 주세요.";
    }

    @Override
    public Integer convert(String inputString) {
        return TypeConverter.convertStringToInteger(inputString, Validator.INTEGER_WITHIN_1_AND_45);
    }
}
