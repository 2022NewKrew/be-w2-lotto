package com.kakao.helper;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextHelper {
<<<<<<< HEAD
    private TextHelper() {}
=======
    private TextHelper(){}
>>>>>>> 4f43f8b (1차 Commit)

    public static List<String> seperateString (String str, String regex) {
        return new ArrayList<>(Arrays.asList(str.split(regex)));
    }

    public static <T,U> List<U> convertListType (List<T> strList, Function<T,U> function) {
        return new ArrayList<>(
                strList.stream()
                        .map(function)
                        .collect(Collectors.toList()));
    }
}
