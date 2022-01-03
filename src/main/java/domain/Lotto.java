package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    Lotto() {
        setUpRandomLotto();
    }

    private void setUpRandomLotto() {
        List<Integer> allLottoNumbers = new LottoNumbers().getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        lotto = allLottoNumbers.subList(0,6);
        Collections.sort(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public String toString() {
        return String.join(", ", lotto.toString());
    }
}
