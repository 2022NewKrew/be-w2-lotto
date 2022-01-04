package view.util;

import java.util.Scanner;

public class ResourceManager {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void close() {
        SCANNER.close();
    }
}
