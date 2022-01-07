package util;

import exception.LottoException;
import validator.ValidatorInterface;

public class ValidatableScanner {
    private ValidatableScanner() {

    }

    public static boolean validate(ValidatorInterface validatorInterface, String input) {
        try {
            validatorInterface.validateData(input);
            return true;
        } catch (LottoException lottoException) {
            System.out.println(lottoException.getMessage());
            return false;
        }
    }
}
