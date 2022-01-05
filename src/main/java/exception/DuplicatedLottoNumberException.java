package exception;

public class DuplicatedLottoNumberException extends RuntimeException {
    public static final String DUPLICATE_NUMBER = "Lotto has duplicated number.";

    public DuplicatedLottoNumberException(String message) {
        super(message);
    }
}
