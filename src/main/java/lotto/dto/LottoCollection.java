package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottoCollection;

    public LottoCollection(int countOfLotto) {
        this(countOfLotto, new ArrayList<>());
    }

    public LottoCollection(int countOfLotto, List<Lotto> lottoCollection) {
        checkNaturalNumber(countOfLotto);
        this.lottoCollection = lottoCollection;
        for(int i = 0; i < countOfLotto; i++) {
            lottoCollection.add(new Lotto());
        }
    }

    private void checkNaturalNumber(int countOfLotto) {
        if (countOfLotto <= 0) {
            throw new IllegalArgumentException("구매하는 값은 자연수 여야 합니다.");
        }
    }

    public List<Lotto> getLottoCollection() {
        return Collections.unmodifiableList(lottoCollection);
    }
}
