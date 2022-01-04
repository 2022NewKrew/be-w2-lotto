package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public interface InputView {
    int getInputPrice();
    LottoNumbers getWinningNumbers();
    LottoNumber getBonusNumber();
}
