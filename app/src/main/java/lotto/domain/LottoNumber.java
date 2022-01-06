package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *  로또 숫자 한 개를 담고 있는 클래스입니다.
 */
public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final List<LottoNumber> instances = new ArrayList<>(MAX_NUMBER);
    private final Integer number;

    /**
     *  어차피 1~45까지 숫자만 있으므로,
     *  45개 숫자에 대한 인스턴스를 미리 만들어 놓고
     *  해당되는 숫자의 인스턴스만 of 메소드를 통해 반환
     */
    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++)
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
            throw new IllegalArgumentException();
    }
}
