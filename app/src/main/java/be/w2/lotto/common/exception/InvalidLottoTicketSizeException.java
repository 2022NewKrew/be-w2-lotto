package be.w2.lotto.common.exception;

public class InvalidLottoTicketSizeException extends RuntimeException {
    public InvalidLottoTicketSizeException() {
        super(INVALID_LOTTO_TICKET_SIZE_EXCEPTION);
    }

    public static final String INVALID_LOTTO_TICKET_SIZE_EXCEPTION = "당첨 번호는 6개의 숫자가 필요합니다.";
}
