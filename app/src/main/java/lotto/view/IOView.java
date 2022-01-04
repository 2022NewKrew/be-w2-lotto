package lotto.view;

import java.util.Scanner;

public final class IOView {

    private IOView() {
    }

    public static int inputToInt(String message, Scanner scanner) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputToString(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
