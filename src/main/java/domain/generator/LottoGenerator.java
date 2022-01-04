package domain.generator;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;

    public static Lotto generate() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUM, LOTTO_END_NUM).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);

        List<Integer> generatedLottoNumbers = new ArrayList<>(lottoNumbers.subList(0, LOTTO_SIZE));
        Collections.sort(generatedLottoNumbers);

        return new Lotto(generatedLottoNumbers);
    }
}
