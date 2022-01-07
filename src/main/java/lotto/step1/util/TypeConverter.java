package lotto.step1.util;

import lotto.step1.exception.CustomFormatException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {

    public static int strToInt(String inputStr, Validator<Integer> validator) throws CustomFormatException {
        try {
            final int result = Integer.parseInt(inputStr);
            validator.validate(result);
            return result;
        } catch (NumberFormatException ex) {
            throw new CustomFormatException("정수를 입력해주세요");
        }
    }

    public static long strToLong(String inputStr, Validator<Long> validator) {
        try {
            final long result = Long.parseLong(inputStr);
            validator.validate(null);
            return result;
        } catch (NumberFormatException ex) {
            throw new CustomFormatException("정수를 입력해주세요");
        }
    }

    public static List<Integer> strToIntList(String inputStr, Validator<Integer> validator) {
        return Arrays.stream(inputStr.split(","))
                .map(tokenStr -> strToInt(tokenStr, validator))
                .collect(Collectors.toList());
    }
}
