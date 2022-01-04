package lotto.util;

import lotto.domain.constant.LottoMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomScanner {
    private final Scanner scanner;

    public CustomScanner() {
        this.scanner = new Scanner(System.in);
    }

    public List<Integer> readCommaSeparatedInt() throws NumberFormatException {
        try {
            return Arrays.stream(scanner.nextLine().split(","))
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(LottoMessage.PARSING_ERROR.toString());
        }
    }

    public int readInt() throws NumberFormatException {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(LottoMessage.PARSING_ERROR.toString());
        }
    }
}
