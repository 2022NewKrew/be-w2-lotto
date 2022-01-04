package input;

import java.util.Scanner;

public class InputResourceManager {
    public static Scanner scanner = new Scanner(System.in);

    public static int nextInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static void close() {
        scanner.close();
    }
}
