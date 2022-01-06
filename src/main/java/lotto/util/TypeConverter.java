package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {

    public static List<Integer> strToIntegerList(String str){
        final List<String> strList = Arrays.asList(str.split(","));
        return strList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
