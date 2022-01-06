package model.lotto.number;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int START_NUMBER = 1;
    public static final int FINAL_NUMBER = 45;

    public static int convertToInt(LottoNumber lottoNumber) {
        return lottoNumber.value;
    }

    private final int value;

    private LottoNumber(int value) {
        checkNumber(value);

        this.value = value;
    }

    private static void checkNumber(int number) {
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

    private static class LottoNumberCache {
        private static final LottoNumber[] cache;

        static {
            cache = new LottoNumber[LottoNumber.FINAL_NUMBER - LottoNumber.START_NUMBER + 1];
            for (int i = 0; i < LottoNumber.FINAL_NUMBER - LottoNumber.START_NUMBER + 1; i++) {
                cache[i] = new LottoNumber(i + LottoNumber.START_NUMBER);
            }
        }
    }

    public static LottoNumber valueOf(int lottoNumber) {
        checkNumber(lottoNumber);

        return LottoNumberCache.cache[lottoNumber - LottoNumber.START_NUMBER];
    }

    @Override
    public int compareTo(LottoNumber otherLottoNumber) {
        return Integer.compare(this.value, otherLottoNumber.value);
    }
}
