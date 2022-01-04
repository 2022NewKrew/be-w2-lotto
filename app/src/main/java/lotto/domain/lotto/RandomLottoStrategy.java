package lotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoStrategy implements LottoStrategy {

    private final static List<Integer> seedNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    @Override
    public List<Integer> create() {
        List<Integer> lottoNumbers = new ArrayList<>();
        Collections.shuffle(seedNumber);
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(seedNumber.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
