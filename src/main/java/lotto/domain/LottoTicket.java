package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket implements LottoNumbersGenerator {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public LottoNumbers generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

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

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
