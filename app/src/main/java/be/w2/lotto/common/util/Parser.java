package be.w2.lotto.common.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static List<Integer> parseInputNumbers(String numbersInput) {
        return Stream.of(numbersInput.split(PARSE_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> parseInputNumbers(List<String> numbersInput) {
        return numbersInput.stream()
                .map(Parser::parseInputNumbers)
                .collect(Collectors.toList());
    }

    private static final String PARSE_DELIMITER = ",";
}
