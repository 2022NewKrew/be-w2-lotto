package model.lotto.number;

public class NumberPrecondition {

    public static void checkNumber(int number) {
        if (isLegalNumber(number)) {
            return;
        }
        throw new IllegalArgumentException(generateExceptionMessage());
    }

    private static boolean isLegalNumber(int number) {
        return number <= LottoNumber.FINAL_NUMBER && number >= LottoNumber.START_NUMBER;
    }

    private static String generateExceptionMessage() {
        return "올바른 범위의 정수를 입력해주세요. 정수의 범위는 "
                + LottoNumber.START_NUMBER
                + " 부터 "
                + LottoNumber.FINAL_NUMBER
                + " 까지입니다.";
    }
}
