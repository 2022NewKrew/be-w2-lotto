package model.number;

public class NumberPrecondition {

    static public void checkNumber(int number) {
        if (isLegalNumber(number)) {
            return;
        }
        throw new IllegalArgumentException(generateExceptionMessage());
    }

    static private boolean isLegalNumber(int number) {
        return number <= Number.FINAL_NUMBER && number >= Number.START_NUMBER;
    }

    static private String generateExceptionMessage() {
        return "올바른 범위의 정수를 입력해주세요. 정수의 범위는 "
                + Number.START_NUMBER
                + " 부터 "
                + Number.FINAL_NUMBER
                + " 까지입니다.";
    }
}
