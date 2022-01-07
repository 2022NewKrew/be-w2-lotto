package exceptions;

public class InvalidPurchaseAmount extends RuntimeException {

    public InvalidPurchaseAmount(String errorMessage) {
        super(errorMessage);
    }
}
