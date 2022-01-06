package util;

import exception.LottoException;
import validator.ValidatorInterface;

import java.util.Scanner;

public abstract class InputData {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputUnitValid(ValidatorInterface validatorInterface) {
        String input;
        do {
            input = getInput();
        } while (!validate(validatorInterface, input));
        return input;
    }

    private static String getInput() {
        return scanner.nextLine()
                .replaceAll(" ", "");
    }

    private static boolean validate(ValidatorInterface validatorInterface, String input) {
        try {
            validatorInterface.validateData(input);
            return true;
        } catch (LottoException lottoException) {
            return false;
        }
    }
}
