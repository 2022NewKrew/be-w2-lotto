package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements LottoNumbersGenerator {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        IntStream.range(MIN_VALUE, MAX_VALUE + 1)
                .forEach(numbers::add);
    }

    public LottoNumbers generateLottoNumbers(String[] strings) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        List<Integer> randomNumbers = generateRandomNumbers();
        for (int randomNumber : randomNumbers) {
            lottoNumbers.add(LottoNumber.from(randomNumber));
        }

        return LottoNumbers.from(lottoNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, LOTTO_NUMBER_COUNT);
    }
}
