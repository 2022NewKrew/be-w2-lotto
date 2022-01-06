package view.util.input;

import view.util.TypeConverter;

public class PositiveNumberInputConsole implements NumberInputConsole<Integer> {
    @Override
    public Integer convert(String inputStr) {
        return TypeConverter.strToInteger(inputStr);
    }
}
