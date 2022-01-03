package view;


import CONST.Const;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputWinningNumber() {
        boolean pass = false;
        List<Integer> winningNumber = null;
        do {
            System.out.println(Const.INPUT_WINNING_NUMBER);
            String stringWinningNumber = scanner.nextLine();
            try {
                winningNumber = Arrays.stream(stringWinningNumber.split(Const.DELIMITER))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                pass = checkWinningNumber(winningNumber);
            } catch (NumberFormatException e) {
                System.out.println(Const.INPUT_INTEGER);
                // Flush Buffer
                scanner.nextLine();
            }
        } while (!pass);
        return winningNumber;
    }

    private static boolean checkWinningNumber(List<Integer> winningNumber) {
        boolean passRange = winningNumber
                .stream()
                .allMatch(n -> n > 0 && n < 46);
        boolean passLength = winningNumber.size() == 6;
        if (passRange && passLength) {
            return true;
        }
        System.out.println(Const.INPUT_SIX_NUMBER);
        return false;
    }

    public static int inputBuyPrice() {
        boolean pass = false;
        int inputIntPrice = 0;
        do {
            System.out.println(Const.INPUT_BUY_PRICE);
            try {
                inputIntPrice = scanner.nextInt();
                pass = isPositiveNumber(inputIntPrice);
            } catch (InputMismatchException e) {
                System.out.println(Const.INPUT_INTEGER);
            }
        } while (!pass);
        return inputIntPrice;
    }

    private static boolean isPositiveNumber(int inputIntPrice) {
        if (inputIntPrice >= 0) {
            return true;
        }
        System.out.println(Const.INPUT_POSITIVE_INTEGER);
        return false;
    }
}