package view;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static void print(Object object) {
        System.out.println(object);
    }

    public static String inputString() {
        return scanner.nextLine();
    }
}
