package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.DuplicatedLottoNumberException;
import com.chanminkim.w2.exception.InvalidLottoNumbersLengthException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBERS_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNumbersLength(lottoNumbers.size());
        validateNoDuplicates(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateNoDuplicates(List<Integer> lottoNumbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer lottoNumber : lottoNumbers) {
            throwIfDuplicated(!set.add(lottoNumber), lottoNumber);
        }
    }

    private void throwIfDuplicated(boolean isDuplicated, Integer lottoNumber) {
        if (isDuplicated) {
            throw new DuplicatedLottoNumberException(lottoNumber);
        }
    }

    private void validateLottoNumbersLength(int length) {
        if (length != NUMBERS_LENGTH) {
            throw new InvalidLottoNumbersLengthException(length);
        }
    }

    public int countMatchedNumbers(Lotto other) {
        Set<LottoNumber> intersection = new HashSet<>(this.lottoNumbers);
        intersection.retainAll(other.lottoNumbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public boolean isContainingBonus(LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }
}
