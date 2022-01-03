package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 6:50
 */
public class LottoGenerator {
    private static final List<Integer> lottoNumber =
            IntStream.range(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    private LottoGenerator() {
        // instance 생성 방지
    }

    public static List<Integer> generateLotto() {
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(0, Constants.LOTTO_SIZE);
    }
}
