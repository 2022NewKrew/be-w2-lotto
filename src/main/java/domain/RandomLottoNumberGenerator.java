package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator {
    private static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final Integer MIN_NUMBER_RANGE= 1;
    private static final Integer MAX_NUMBER_RANGE = 46;

    public static LottoNumbers generate() {
        List<Integer> lottoNumberList = IntStream.range(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumberList);

        return new LottoNumbers(
                lottoNumberList.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList()));
    }
}
