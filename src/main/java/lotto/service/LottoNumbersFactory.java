package lotto.service;

import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static LottoNumbers createRandomLottoNumbers() {
        return new LottoNumbers(randomLottoNumbers().subList(0, LOTTO_SIZE).stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    private static List<Integer> randomLottoNumbers() {
        List<Integer> randomLottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(randomLottoNumbers);
        return randomLottoNumbers;
    }
}
