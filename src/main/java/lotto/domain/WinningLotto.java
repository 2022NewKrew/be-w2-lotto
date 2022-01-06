package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.Lotto.CHECK_DUPLICATION_MESSAGE;
import static lotto.domain.Lotto.CHECK_LOTTO_NUMBER_MESSAGE;
import static lotto.domain.LottoNumber.MAX_NUMBER;
import static lotto.domain.LottoNumber.MIN_NUMBER;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        checkDuplicationInWinningLotto(lotto, bonusNumber);
        checkLottoNumber(bonusNumber);
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

    private void checkLottoNumber(@NotNull LottoNumber lottoNumber) {
        if (MIN_NUMBER > lottoNumber.getNumber() || lottoNumber.getNumber() > MAX_NUMBER)
            throw new IllegalArgumentException(CHECK_LOTTO_NUMBER_MESSAGE);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
