package lotto;

import static lotto.view.LottoOutputPrinter.*;

public class IllegalLottoNumberException extends RuntimeException {
    public IllegalLottoNumberException() {
        super(CHECK_LOTTO_NUMBER_MESSAGE);
    }
}

