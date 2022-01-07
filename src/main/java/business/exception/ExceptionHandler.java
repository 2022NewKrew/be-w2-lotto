package business.exception;

public class ExceptionHandler {

    public void handle(RuntimeException exception) {
        System.err.println(exception.getMessage());
        System.exit(1);
    }
}
