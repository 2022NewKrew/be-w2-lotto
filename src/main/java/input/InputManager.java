package input;

import java.util.Scanner;

public class InputManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void close() {
        scanner.close();
    }
}
