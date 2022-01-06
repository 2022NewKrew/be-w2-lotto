package lotto;

import static lotto.view.LottoOutputPrinter.CHECK_DUPLICATION_MESSAGE;

public class DuplicationException extends RuntimeException {
    public DuplicationException() {
        super(CHECK_DUPLICATION_MESSAGE);
    }
}
