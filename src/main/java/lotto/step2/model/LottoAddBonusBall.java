package lotto.step2.model;

import lotto.step1.model.Lotto;
import lotto.step1.model.LottoNumbers;

import java.util.List;

public class LottoAddBonusBall extends Lotto {
    public LottoAddBonusBall(List<LottoNumbers> purchasedLottoNumbersList) {
        super(purchasedLottoNumbersList);
    }

    public void confirmTheWin(List<Integer> winningNumbers, int bonusBall) {
        for (LottoNumbers lottoNumbers : purchasedLottoNumbersList) {
            confirmTheWinAddBonusBall(winningNumbers, bonusBall, lottoNumbers);
        }
    }

    private void confirmTheWinAddBonusBall(List<Integer> winningNumbers, int bonusBall, LottoNumbers lottoNumbers) {
        if (lottoNumbers instanceof LottoNumbersAddBonusBall lottoNumbersAddBonusBall) {
            lottoNumbersAddBonusBall.confirmTheWinAddBonusBall(winningNumbers, bonusBall);
        }
    }
}
