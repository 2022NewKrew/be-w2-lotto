package com.kakao.lottogame.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class Lotto {

    public static final int SIZE = 6;
    public static final Money PRICE = Money.of(1_000);

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 총 6개입니다.");
        }
    }

    public int compare(Lotto lotto) {
        Set<LottoNumber> intersectSet = new HashSet<>(lottoNumbers);
        intersectSet.retainAll(lotto.lottoNumbers);
        return intersectSet.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }

    @Override
    public String toString() {
        final String SEPARATOR = ", ";
        return "[" + StringUtils.join(this.lottoNumbers, SEPARATOR) + "]";
    }
}
