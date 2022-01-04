package model.scan;

import validator.ValidatorInterface;

import java.util.Scanner;

public abstract class InputData {
    private static final Scanner scanner = new Scanner(System.in);
    protected ValidatorInterface validatorInterface;

    protected static String getInput(){
        return scanner.nextLine()
                .replaceAll(" ", "");
    }
}
