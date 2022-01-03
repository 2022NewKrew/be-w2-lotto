package lotto.step1.util.consoleInput;


import lotto.step1.exception.ConsoleInputCountExceededException;
import lotto.step1.exception.CustomFormatException;

import java.util.Scanner;

public interface InputConsole<T> {
    int THRESHOLD = 3;
    Scanner sc = new Scanner(System.in);

    String getMsg();

    T convert(String inputStr);

    default T read() throws ConsoleInputCountExceededException {
        return read(0);
    }

    private T read(int count) throws ConsoleInputCountExceededException {
        System.out.printf("%s %d/%d%n", getMsg(), count, THRESHOLD);

        try {
            checkThresholdAndThrowException(count);

            final String inputStr = sc.nextLine();
            return convert(inputStr);
        } catch (CustomFormatException e) {
            System.out.println(e.getMessage());
            return read(count + 1);
        }
    }

    private void checkThresholdAndThrowException(int count) {
        if (count >= THRESHOLD) {
            throw new ConsoleInputCountExceededException();
        }
    }
}
