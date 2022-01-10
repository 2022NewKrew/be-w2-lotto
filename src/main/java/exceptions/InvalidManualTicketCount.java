package exceptions;

public class InvalidManualTicketCount extends RuntimeException {

    public InvalidManualTicketCount(String errorMessage) {
        super(errorMessage);
    }
}

