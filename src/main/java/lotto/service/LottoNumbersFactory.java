package lotto.service;

import lotto.domain.Constants;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoNumbersFactory {

    private static final Random random = new Random();

    public static LottoNumbers createRandomLottoNumbers() {
        return new LottoNumbers(randomLottoNumbers());
    }

    private static List<Integer> randomLottoNumbers() {
        return random.ints(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER_BOUND)
                .distinct()
                .limit(Constants.LOTTO_SIZE)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }
}
