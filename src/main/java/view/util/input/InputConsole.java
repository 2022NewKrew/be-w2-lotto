package view.util.input;

import view.util.ResourceManager;

import java.util.Scanner;

public interface InputConsole<T> {

    default T read(String msg, Scanner sc) {
        System.out.println(msg);
        try {
            final String inputStr = sc.nextLine();
            return convert(inputStr);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return read(msg, sc);
        }
    }

    T convert(String inputStr);
}
