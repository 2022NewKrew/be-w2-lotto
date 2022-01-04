package domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private final List<Number> numbers;

    public LottoNumber(List<Number> numbers) {
        this.numbers = numbers;
    }

    public void sortNumbers() {
        Collections.sort(numbers);
    }

    public String numbersToString() {
        return numbers.stream()
                .map(Number::getValue)
                .map(n -> Integer.toString(n))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static LottoNumber makeSixNumbersByRandom() {
        RandomBucket randomBucket = new RandomBucket();

        LottoNumber lottoNumberByRandom = new LottoNumber(randomBucket.getSixRandomNumber());
        lottoNumberByRandom.sortNumbers();

        return lottoNumberByRandom;
    }

    public int compareLottoNumber(LottoNumber targetLottoNumber) {
        int sameCnt = 0;

        for (Number targetNum : targetLottoNumber.numbers) {
            sameCnt += numbers.stream()
                    .filter(n -> n.isSame(targetNum))
                    .collect(Collectors.toList())
                    .size();
        }

        return sameCnt;
    }

    public int compareBonusNumber(Number bonusNumber) {
        return numbers.stream()
                .filter(n -> n.isSame(bonusNumber))
                .collect(Collectors.toList())
                .size();
    }
}
