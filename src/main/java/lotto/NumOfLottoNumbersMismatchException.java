package lotto;

import static lotto.view.LottoOutputPrinter.CHECK_NUM_OF_LOTTO_NUMBERS;

public class NumOfLottoNumbersMismatchException extends RuntimeException {
    public NumOfLottoNumbersMismatchException() {
        super(CHECK_NUM_OF_LOTTO_NUMBERS);
    }
}
