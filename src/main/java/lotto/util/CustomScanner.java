package lotto.util;

import java.util.List;
import java.util.Scanner;

public class CustomScanner {
    private final Scanner scanner;

    public CustomScanner() {
        this.scanner = new Scanner(System.in);
    }

    public List<Long> readCommaSeparatedLong() throws NumberFormatException {
        return StringConverter.parseCommaSeparatedInt(scanner.nextLine());
    }

    public long readLong() throws NumberFormatException {
        return StringConverter.convertToLong(scanner.nextLine());
    }
}
