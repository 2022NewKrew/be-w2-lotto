package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.DuplicatedLottoNumberException;
import com.chanminkim.w2.exception.InvalidLottoNumbersLengthException;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBERS_LENGTH_LIMIT = 6;
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }

    public static class Builder {
        private final List<LottoNumber> numbers = new ArrayList<>();

        public Lotto buildRandomly() {
            List<Integer> pickedNumbers = pickLottoNumbersRandomly();
            numbers.clear();
            numbers.addAll(pickedNumbers.stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));
            return build();
        }

        private List<Integer> pickLottoNumbersRandomly() {
            List<Integer> allLottoNumbers = new ArrayList<>(getAllLottoNumbers());
            Collections.shuffle(allLottoNumbers);
            List<Integer> pickedNumbers = allLottoNumbers.subList(0, LOTTO_NUMBERS_LENGTH_LIMIT);
            pickedNumbers.sort(Integer::compareTo);
            return pickedNumbers;
        }

        private ImmutableList<Integer> getAllLottoNumbers() {
            return ContiguousSet.create(
                            LottoNumber.LOTTO_NUMBER_RANGE,
                            DiscreteDomain.integers())
                    .asList();
        }

        public Lotto build() {
            if (numbers.size() != LOTTO_NUMBERS_LENGTH_LIMIT) {
                throw new InvalidLottoNumbersLengthException(numbers.size());
            }
            return new Lotto(numbers);
        }

        public Builder add(LottoNumber number) {
            if (numbers.contains(number)) {
                throw new DuplicatedLottoNumberException(number);
            }
            numbers.add(number);
            return this;
        }
    }
}
