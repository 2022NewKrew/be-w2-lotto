package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import util.RandomUtil;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static Lotto purchaseLotto() {
        List<Integer> shuffledNumbers = RandomUtil.generateRandomNumbers();
        List<LottoNumber> lottoNumbers = shuffledNumbers.stream()
            .map(LottoNumber::new)
            .sorted(Comparator.comparing(LottoNumber::getNumber))
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
