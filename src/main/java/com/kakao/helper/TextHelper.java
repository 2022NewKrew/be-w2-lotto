package com.kakao.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextHelper {

    private TextHelper() {}

    public static List<String> seperateString (String str, String regex) {
        return new ArrayList<>(Arrays.asList(str.split(regex)));
    }

    public static <T,U> List<U> convertListType (List<T> list, Function<T,U> function) {
        return list.stream()
                .map(function).collect(Collectors.toList());
    }
}
