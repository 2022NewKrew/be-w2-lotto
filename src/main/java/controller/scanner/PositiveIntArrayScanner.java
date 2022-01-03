package controller.scanner;

import java.util.ArrayList;

public class PositiveIntArrayScanner implements BaseScanner<ArrayList<Integer>> {
    private static final String DELIMITER = ",";
    private int arraySize = -1;
    private int minRange = 1;
    private int maxRange = -1;

    @Override
    public ArrayList<Integer> parse(String s) {
        return parseStringArrayToIntArray(s.split(DELIMITER));
    }

    private ArrayList<Integer> parseStringArrayToIntArray(String[] values) {
        ArrayList<Integer> intArray = new ArrayList<>();
        for (String value : values) {
            intArray.add(parseInt(value.trim()));
        }
        return intArray;
    }

    private Integer parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new TypeScannerException("정수형을 입력하세요.");
        }
    }

    @Override
    public void validate(ArrayList<Integer> value) {
        validateArrayLength(value);
        for (Integer i : value) {
            validateMinRange(i);
            validateMaxRange(i);
        }
    }

    private void validateArrayLength(ArrayList<Integer> value) {
        if (arraySize == -1) {
            return;
        }
        if (value.size() != arraySize) {
            throw new TypeScannerException("개수는 " + arraySize + "개여야 합니다.");
        }
    }

    private void validateMinRange(Integer i) {
        if (i < minRange) {
            throw new TypeScannerException("숫자는 " + minRange + "이상이어야 합니다.");
        }
    }

    private void validateMaxRange(Integer i) {
        if (maxRange == -1) {
            return;
        }
        if (i > maxRange) {
            throw new TypeScannerException("숫자는 " + maxRange + "이하여야 합니다.");
        }
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }
}
