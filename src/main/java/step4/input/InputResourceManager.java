package step4.input;

import java.util.Scanner;

public class InputResourceManager {
    public static Scanner scanner = new Scanner(System.in);

    public static int nextInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static int nextIntWithMessage(String msg) {
        System.out.println(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static String nextLineWithMessage(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static void close() {
        scanner.close();
    }
}
