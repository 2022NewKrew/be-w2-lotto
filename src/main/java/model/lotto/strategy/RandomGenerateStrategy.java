package model.lotto.strategy;

import model.lotto.number.LottoNumber;
import utility.RandomSeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerateStrategy implements GenerateLottoStrategy {
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = getLegalNumbers();
    }

    @Override
    public List<LottoNumber> generate() {
        return generateRandomNumbers();
    }

    private static List<LottoNumber> getLegalNumbers() {
        return IntStream
                .rangeClosed(LottoNumber.START_NUMBER, LottoNumber.FINAL_NUMBER)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> targetLottoNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(targetLottoNumbers, RandomSeed.getRandom());
        targetLottoNumbers = new ArrayList<>(targetLottoNumbers.subList(0, 6));
        Collections.sort(targetLottoNumbers);
        return Collections.unmodifiableList(targetLottoNumbers);
    }
}
