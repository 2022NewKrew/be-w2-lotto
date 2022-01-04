package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.DuplicatedLottoNumberException;
import com.chanminkim.w2.exception.InvalidLottoNumbersLengthException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBERS_LENGTH_LIMIT = 6;

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
        if (length != LOTTO_NUMBERS_LENGTH_LIMIT) {
            throw new InvalidLottoNumbersLengthException(length);
        }
    }

    public int countMatchedNumbers(Lotto other) {
        int count = 0;
        for (int i = 0; i < this.lottoNumbers.size(); i++) {
            count += this.lottoNumbers.get(i).equals(other.lottoNumbers.get(i)) ? 1 : 0;
        }
        return count;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
