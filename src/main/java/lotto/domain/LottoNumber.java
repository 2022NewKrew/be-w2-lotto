package lotto.domain;

import org.jetbrains.annotations.NotNull;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int digit;

    public LottoNumber(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    @Override
    public int compareTo(@NotNull LottoNumber lottoNumber) {
        return this.digit - lottoNumber.getDigit();
    }
}
