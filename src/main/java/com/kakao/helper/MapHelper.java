package com.kakao.helper;

import java.util.Map;

public class MapHelper {
    private MapHelper(){}

    private static int DEFAULT_INTEGER_VALUE = 0;

    public static <T> int getIntegerValue(Map<T,Integer> map, T key) {
        Integer value = map.get(key);
        if( value == null ){
            value = DEFAULT_INTEGER_VALUE;
        }
        return value;
    }
}
