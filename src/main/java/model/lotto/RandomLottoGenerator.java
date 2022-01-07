package model.lotto;

import model.lotto.number.LottoNumber;
import utility.RandomSeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator {
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = getLegalNumbers();
    }

    private static List<LottoNumber> getLegalNumbers() {
        return IntStream
                .rangeClosed(LottoNumber.START_NUMBER, LottoNumber.FINAL_NUMBER)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> generate() {
        return generateRandomNumbers();
    }

    private static List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> targetLottoNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(targetLottoNumbers, RandomSeed.getRandom());
        targetLottoNumbers = new ArrayList<>(targetLottoNumbers.subList(0, 6));
        Collections.sort(targetLottoNumbers);
        return targetLottoNumbers;
    }
}
