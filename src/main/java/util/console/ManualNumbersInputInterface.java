package util.console;

import util.TypeConverter;
import util.Validator;

import java.util.List;

public class ManualNumbersInputInterface implements InputInterface<List<Integer>> {
    @Override
    public String getMsg() {
        return "수동으로 구매할 번호를 입력해 주세요.";
    }

    @Override
    public List<Integer> convert(String inputString) {
        return TypeConverter.convertStringToIntegerList(inputString, Validator.INTEGER_WITHIN_1_AND_45, Validator.LIST_SIZE_EQUAL_TO_6);
    }
}
