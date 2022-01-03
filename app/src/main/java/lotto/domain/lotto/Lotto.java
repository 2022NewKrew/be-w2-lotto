package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> lottoNumber;

    private Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static Lotto createLotto(LottoStrategy strategy) {
        return new Lotto(strategy.create());
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
