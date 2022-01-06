package controller.type;

public class PositiveInteger {

    public static int parse(String s) {
        try {
            int value = Integer.parseInt(s.strip());
            validatePositive(value);
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수형을 입력하세요.");
        }
    }

    private static void validatePositive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("양의 정수를 입력하세요.");
        }
    }
}
