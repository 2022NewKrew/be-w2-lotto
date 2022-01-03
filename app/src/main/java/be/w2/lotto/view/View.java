package be.w2.lotto.view;

import java.util.Scanner;

/**
 * Singleton
 */
public class View {

    private static View INSTANCE;

    private View() {
        this.scanner = new Scanner(System.in);
    }

    public static synchronized View getInstance() {
        if (INSTANCE == null)
            INSTANCE = new View();
        return INSTANCE;
    }

    private final Scanner scanner;

    public int inputIntWithMessage(String message) {
        output(message);
        return scanner.nextInt();
    }

    public String inputStringWithMessage(String message) {
        output(message);
        return scanner.next();
    }

    public void output(String str) {
        System.out.println(str);
    }
}
