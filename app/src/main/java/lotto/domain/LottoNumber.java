package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final List<LottoNumber> instances = new ArrayList<>(MAX_NUMBER);
    private final Integer number;

    static {
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++)
            instances.add(new LottoNumber(i));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        checkNumber(number);
        return instances.get(number-1);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number.compareTo(lottoNumber.number);
    }

    @Override
    public String toString() {
        return number.toString();
    }

    private static void checkNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER)
            throw new NoSuchElementException();
    }
}
