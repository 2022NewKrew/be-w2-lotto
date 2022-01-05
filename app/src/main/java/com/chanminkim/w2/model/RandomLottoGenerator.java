package com.chanminkim.w2.model;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator {
    private static final List<Integer> ALL_LOTTO_NUMBERS = getAllLottoNumbers();

    private RandomLottoGenerator() {
    }

    public static Lotto generateLotto() {
        List<Integer> pickedNumbers = pickLottoNumbersRandomly();
        return new Lotto(pickedNumbers);
    }

    private static List<Integer> pickLottoNumbersRandomly() {
        List<Integer> allLottoNumbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
        Collections.shuffle(allLottoNumbers);
        List<Integer> pickedNumbers = allLottoNumbers.subList(0, Lotto.NUMBERS_LENGTH);
        pickedNumbers.sort(Integer::compareTo);
        return pickedNumbers;
    }

    private static ImmutableList<Integer> getAllLottoNumbers() {
        return ContiguousSet.create(
                        LottoNumber.LOTTO_NUMBER_RANGE,
                        DiscreteDomain.integers())
                .asList();
    }
}
