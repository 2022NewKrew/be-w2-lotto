package presentation.converter;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringToNumbersConverter implements Converter<String, List<Integer>> {
    private static final StringToNumbersConverter instance = new StringToNumbersConverter();

    private StringToNumbersConverter(){

    }

    public static StringToNumbersConverter getInstance(){
        return instance;
    }

    @Override
    public List<Integer> apply(String param) {
        return Arrays.stream(param.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
    }
}
