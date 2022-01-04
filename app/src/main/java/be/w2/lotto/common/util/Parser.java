package be.w2.lotto.common.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static List<Integer> parseInputNumbers(String winningNumbersInput) {
        return Stream.of(winningNumbersInput.split(PARSE_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static final String PARSE_DELIMITER = ",";
}
