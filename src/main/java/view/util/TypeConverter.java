package view.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {
    public static final String COMMA_SEPARATED_REGEX = ",";

    public static int strToInteger(String str) {
        try {
            final int result = Integer.parseInt(str);
            Validator.isPositive(result);
            return result;
        } catch (NumberFormatException ex) {
            throw new RuntimeException("잘못된 타입입니다. 양의 정수를 입력해주세요.");
        }
    }

    public static List<Integer> strToListInteger(String str) {
        return Arrays.stream(str.split(COMMA_SEPARATED_REGEX))
                .map(TypeConverter::strToInteger)
                .collect(Collectors.toList());
    }
}
