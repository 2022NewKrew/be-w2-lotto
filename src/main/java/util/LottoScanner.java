package util;

import validator.ValidatorInterface;

import java.util.Scanner;

public class LottoScanner {
    private LottoScanner() {

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputUnitValid(ValidatorInterface validatorInterface) {
        String input;
        do {
            input = scanner.nextLine();
            input = WhiteSpaceRemover.remove(input);
        } while (!ValidatableScanner.validate(validatorInterface, input));
        return input;
    }
}
