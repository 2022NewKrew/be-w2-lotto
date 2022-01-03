package controller.scanner;

public class PositiveIntScanner implements BaseScanner<Integer> {
    @Override
    public Integer parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new TypeScannerException("정수형을 입력하세요.");
        }
    }

    @Override
    public void validate(Integer value) {
        if (value < 1) {
            throw new TypeScannerException("양의 정수를 입력하세요.");
        }
    }
}
