package model.scan;

import exception.LottoException;
import validator.ValidatorInterface;

import java.util.Scanner;

public abstract class InputData {
    private static final Scanner scanner = new Scanner(System.in);

    protected static String getInput() {
        return scanner.nextLine()
                .replaceAll(" ", "");
    }

    protected static String validateAndGetInput(ValidatorInterface validatorInterface) {
        String input;
        while (true) {
            // while - try로 이어지는 2중 indent가 안되려면 재귀로 재귀밖에 생각이 안나는데, 너무 비효율적 같습니다.
            // 다른 방안이 있는지 궁금합니다.
            try {
                input = getInput();
                validatorInterface.validateData(input);
                return input;
            } catch (LottoException lottoException) {
                System.out.println(lottoException.getMessage());
            }
        }
    }
}
