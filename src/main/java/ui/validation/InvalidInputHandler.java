package ui.validation;

public class InvalidInputHandler {

    public void handle(RuntimeException exception) {
        System.err.println(exception.getMessage());
        System.exit(1);
    }
}
