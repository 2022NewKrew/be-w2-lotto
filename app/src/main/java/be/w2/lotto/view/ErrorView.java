package be.w2.lotto.view;

public class ErrorView {
    public static void throwErrorMessage(Exception e) {
        System.out.println(e.getLocalizedMessage() + "\n");
    }
}
