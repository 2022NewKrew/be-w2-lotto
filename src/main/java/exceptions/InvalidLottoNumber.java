package exceptions;

public class InvalidLottoNumber extends RuntimeException {

    public InvalidLottoNumber(String errorMessage) {
        super(errorMessage);
    }
}
