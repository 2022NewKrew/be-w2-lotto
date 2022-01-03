package be.w2.lotto.view;

import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

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
