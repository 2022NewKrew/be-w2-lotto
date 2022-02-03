package domain.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtils {
    public static List<Integer> splitSixNum(String numbers) {
        String replace = numbers.replace(" ", "");

        return Arrays.stream(replace.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
