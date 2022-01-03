package lotto.domain.lotto;

import java.util.*;

public class RandomLottoStrategy implements LottoStrategy {

    private final List<Integer> seedNumber;

    public RandomLottoStrategy() {
        this.seedNumber = new ArrayList<>();
        initialSeedNumber();
    }

    @Override
    public List<Integer> create() {
        List<Integer> lottoNumbers = new ArrayList<>();
        Collections.shuffle(seedNumber);
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(seedNumber.get(i));
        }
        return lottoNumbers;
    }

    private void initialSeedNumber() {
        for (int number = 1; number <= 45; number++) {
            seedNumber.add(number);
        }
    }
}
