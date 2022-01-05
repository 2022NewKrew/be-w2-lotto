package util.console.input;

import java.util.Scanner;

public interface InputInterface<T> {
    int THRESHOLD = 3;

    Scanner scanner = new Scanner(System.in);

    String getMsg();

    T convert(String inputString);

    default T read() {
        return read(1);
    }

    private T read(int count) {
        System.out.printf("%s %d/%d\n", getMsg(), count, THRESHOLD);

        try {
            checkTryExceedThreshold(count);

            String inputString = scanner.nextLine();
            return convert(inputString);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return read(++count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void checkTryExceedThreshold(int count) throws Exception {
        if (count > THRESHOLD)
            throw new Exception();
    }
}
