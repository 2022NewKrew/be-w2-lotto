package view.util.input;

import view.util.TypeConverter;

import java.util.List;

public class PositiveNumberListInputConsole implements InputConsole<List<Integer>> {
    @Override
    public List<Integer> convert(String inputStr) {
        return TypeConverter.strToListInteger(inputStr);
    }
}
