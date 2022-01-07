package lotto.util;

import lotto.domain.constant.LottoMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    public static List<String> multiLineStringToList(String s) {
        return Arrays.stream(s.trim().split("\n"))
                .map(line -> line.trim())
                .filter(line -> !line.equals(""))
                .collect(Collectors.toList());
    }

    public static List<Long> parseCommaSeparatedInt(String s) throws NumberFormatException {
        try {
            return Arrays.stream(s.split(","))
                    .map(number -> Long.parseLong(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(LottoMessage.PARSING_ERROR.toString());
        }
    }

    public static Long convertToLong(String s) throws NumberFormatException {
        try {
            return Long.parseLong(s.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(LottoMessage.PARSING_ERROR.toString());
        }
    }
}
