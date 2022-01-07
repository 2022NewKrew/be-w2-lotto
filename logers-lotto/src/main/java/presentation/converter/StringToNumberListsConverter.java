package presentation.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringToNumberListsConverter implements Converter<String, List<List<Integer>>> {
    private static final StringToNumberListsConverter instance = new StringToNumberListsConverter();

    private final StringToNumbersConverter stringToNumbersConverter;

    private StringToNumberListsConverter() {
        stringToNumbersConverter = StringToNumbersConverter.getInstance();
    }

    public static StringToNumberListsConverter getInstance(){
        return instance;
    }

    @Override
    public List<List<Integer>> apply(String numberListsString){
        if(numberListsString.length() == 0){
            return Collections.emptyList();
        }

        return Arrays.stream(numberListsString.split("\n"))
                .map(stringToNumbersConverter::apply)
                .collect(toList());
    }
}
