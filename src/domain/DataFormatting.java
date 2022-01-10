package domain;

import exceptions.DuplicatedNumberException;
import view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataFormatting {
    public static List<String> parseString(String string) {
        return Arrays.asList(string.split(","));
    }

    public static List<Integer> stringListToIntegerList(List<String> stringList) {
        return stringList.stream().map(s -> stringToInteger(s)).collect(Collectors.toList());
    }

    public static int stringToInteger(String string) throws NumberFormatException {
        return Integer.parseInt(string);
    }


    public static int booleanToInteger(boolean b) {
        if (b) {
            return 1;
        }
        return 0;
    }
}
