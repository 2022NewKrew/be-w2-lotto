package lotto.exception;

import static lotto.view.LottoOutputPrinter.CHECK_LOTTO_NUMBER_MESSAGE;

public class IllegalLottoNumberException extends RuntimeException {

    public IllegalLottoNumberException() {
        super(CHECK_LOTTO_NUMBER_MESSAGE);
    }
}

