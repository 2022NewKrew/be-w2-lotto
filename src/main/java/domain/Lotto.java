package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.RandomUtil;

public class Lotto {
    private static final int LOTTO_SIZE_MIN = 0;
    private static final int LOTTO_SIZE_MAX = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static Lotto purchaseLotto() {
        List<Integer> shuffledNumbers = RandomUtil.generateRandomNumbers();
        List<LottoNumber> lottoNumbers = IntStream.range(LOTTO_SIZE_MIN, LOTTO_SIZE_MAX)
            .map(shuffledNumbers::get)
            .mapToObj(LottoNumber::new)
            .sorted(Comparator.comparing(LottoNumber::getNumber))
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
