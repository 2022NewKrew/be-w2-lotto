package lotto.step2.model;

import lotto.step1.model.LottoNumbers;
import lotto.step1.model.LottoResult;

import java.util.List;

public class LottoNumbersAddBonusBall extends LottoNumbers {
    public LottoNumbersAddBonusBall(List<Integer> numbers) {
        super(numbers);
    }

    public void confirmTheWinAddBonusBall(List<Integer> winningNumbers, int bonusBall) {
        super.confirmTheWin(winningNumbers);

        if (result != LottoResult.SECOND_PLACE) {
            return;
        }

        if (numbers.contains(bonusBall)) {
            result = LottoResult.BONUS_PLACE;
        }
    }
}
