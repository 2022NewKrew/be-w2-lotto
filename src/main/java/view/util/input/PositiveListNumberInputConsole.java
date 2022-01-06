package view.util.input;

import view.util.TypeConverter;

import java.util.List;

public class PositiveListNumberInputConsole implements NumberInputConsole<List<Integer>> {
    @Override
    public List<Integer> convert(String inputStr) {
        return TypeConverter.strWithCommaToListInteger(inputStr);
    }
}
