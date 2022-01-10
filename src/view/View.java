package view;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public void print(Object object) {
        System.out.println(object);
    }

    public String inputString() {
        return scanner.nextLine();
    }
}
