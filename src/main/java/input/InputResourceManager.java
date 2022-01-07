package input;

import java.util.Scanner;

public class InputResourceManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void close() {
        scanner.close();
    }
}
