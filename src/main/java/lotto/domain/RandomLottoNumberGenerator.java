package lotto.domain;

import java.util.*;

public class RandomLottoNumberGenerator implements LottoNumbersGenerator {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public LottoNumbers generateLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        List<Integer> randomNumbers = generateRandomNumbers();
        for (int randomNumber : randomNumbers) {
            lottoNumbers.add(LottoNumber.from(randomNumber));
        }

        return LottoNumbers.from(lottoNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        return numbers.subList(0, LOTTO_NUMBER_COUNT);
    }
}
