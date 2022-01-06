package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.Lotto.CHECK_DUPLICATION_MESSAGE;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        checkDuplicationInWinningLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicationInWinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumberList = new ArrayList<>(lotto.getNumberList());
        lottoNumberList.add(bonusNumber);
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumberList);
        if (lottoNumberList.size() != lottoNumberSet.size()) {
            throw new IllegalArgumentException(CHECK_DUPLICATION_MESSAGE);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
