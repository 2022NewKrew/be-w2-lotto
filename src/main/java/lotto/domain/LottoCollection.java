package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottoCollection;

    public LottoCollection(List<Lotto> lottoCollection) { this(0, lottoCollection);}

    public LottoCollection(int countOfRandomLotto) {
        this(countOfRandomLotto, new ArrayList<>());
    }

    public LottoCollection(int countOfRandomLotto, List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
        if(countOfRandomLotto > 0) {
            createRandomLotto(countOfRandomLotto);
        }
    }

    private void createRandomLotto(int countOfRandomLotto) {
        checkNaturalNumber(countOfRandomLotto);
        for(int i = 0; i < countOfRandomLotto; i++) {
            this.lottoCollection.add(new Lotto());
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
