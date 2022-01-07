package step3.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {

    // DB 에서 꺼내온 Lotto의 String([1,2,3,4,5]) 를 List<Integer> 로 변환
    public static List<Integer> DB_LOTTO_CONVERT(String strList){
        strList = strList.replace("[", "");
        strList = strList.replace("]", "");
        List<String> list2 = Arrays.asList(strList.split(","));
        return list2.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
