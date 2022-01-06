package utility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Parser {
    private static final String SEPARATOR = ",";

    public static List<Integer> parseIntegerFromLine(String line) {
        return Arrays.stream(line.split(SEPARATOR))
                     .map(String::trim).map(Integer::valueOf)
                     .collect(Collectors.toList());
    }

    public static List<List<Integer>> parseNumbers(List<String> inputNumbers) {
        return inputNumbers.stream()
                           .map(Parser::parseIntegerFromLine)
                           .collect(Collectors.toList());
    }
}

