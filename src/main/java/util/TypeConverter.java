package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {
    public static Integer convertStringToInteger(String string, Validator<Integer> validator) {
        final int result = Integer.parseInt(string);
        validator.validate(result);
        return result;
    }

    public static Long convertStringToLong(String string, Validator<Void> validator) {
        final long result = Long.parseLong(string);
        return result;
    }

    public static List<Integer> convertStringToIntegerList(String string, Validator<Integer> validator) {
        return Arrays
                .stream(string.split(","))
                .map(token -> convertStringToInteger(token.trim(), validator))
                .collect(Collectors.toList());
    }

    public static List<Integer> convertStringToIntegerList(String string, Validator<Integer> validatorOfElement, Validator<List<Integer>> validatorOfSize) {
        final List<Integer> results = convertStringToIntegerList(string, validatorOfElement);
        validatorOfSize.validate(results);
        return results;
    }
}
