package controller.scanner;

import java.util.Scanner;

public interface BaseScanner<T> {
    Scanner scanner = new Scanner(System.in);

    default T getValue() {
        T value = parse(scanner.nextLine());
        validate(value);
        return value;
    }

    T parse(String s);

    default void validate(T value) {}
}
