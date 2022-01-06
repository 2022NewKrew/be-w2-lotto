package lotto.domain;

import lotto.DuplicationException;

import java.util.*;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) throws DuplicationException {
        checkDuplicationInWinningLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicationInWinningLotto(Lotto lotto, LottoNumber bonusNumber) throws DuplicationException {
        List<LottoNumber> lottoNumberList = new ArrayList<>(lotto.getNumberList());
        lottoNumberList.add(bonusNumber);
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumberList);
        if (lottoNumberList.size() != lottoNumberSet.size()) {
            throw new DuplicationException();
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Optional<LottoResult> getPurchasedResult(Lotto purchasedLotto) {
        return LottoResult.getResult(lotto.getNumOfMatchingNumbersWith(purchasedLotto), purchasedLotto.containsLottoNumber(bonusNumber));
    }
}
