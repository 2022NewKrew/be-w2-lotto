package be.w2.lotto.lottos;

import be.w2.lotto.exceptions.NonValidLottoNumberException;
import be.w2.lotto.messages.ErrorMessage;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUM_IN_LOTTO = 1;
    public static final int MAX_NUM_IN_LOTTO = 45;

    private static final LottoNumber[] INSTANCES;

    static {
        INSTANCES = new LottoNumber[MAX_NUM_IN_LOTTO + 1];
        for (int i = MIN_NUM_IN_LOTTO; i <= MAX_NUM_IN_LOTTO; i++) {
            INSTANCES[i] = new LottoNumber(i);
        }
    }

    private final Integer value;

    private LottoNumber(int num) {
        this.value = num;
    }

    public static LottoNumber of(String stringOfNumber) {
        return of(Integer.parseInt(stringOfNumber));
    }

    public static LottoNumber of(int number) {
        if (isNotInRangeOfLottoNumber(number))
            throw new NonValidLottoNumberException(ErrorMessage.NON_VALID_LOTTO_NUMBER);
        return INSTANCES[number];
    }

    private static boolean isNotInRangeOfLottoNumber(int num) {
        return MIN_NUM_IN_LOTTO > num || num > MAX_NUM_IN_LOTTO;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof LottoNumber)
            return this.value.equals(((LottoNumber) o).value);
        return false;
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
