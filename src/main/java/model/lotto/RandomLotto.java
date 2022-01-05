package model.lotto;

import model.lotto.number.LottoNumber;
import utility.RandomSeed;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLotto{
    private final Lotto lotto;

    private static final List<LottoNumber> LOTTO_NUMBERS =
            IntStream.rangeClosed(LottoNumber.START_NUMBER, LottoNumber.FINAL_NUMBER)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toUnmodifiableList());

    public RandomLotto() {
        lotto = new Lotto(generateRandomNumbers());
    }



    private List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> targetLottoNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(targetLottoNumbers, RandomSeed.getRandom());
        targetLottoNumbers = new ArrayList<>(targetLottoNumbers.subList(0, 6));
        Collections.sort(targetLottoNumbers);
        LottoPrecondition.checkNumbers(targetLottoNumbers);
        return targetLottoNumbers;
    }

    public Lotto getLotto() {
        return lotto;
    }
}
