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
            }
        } while (!pass);
        return winningNumber;
    }

    private static boolean checkWinningNumber(List<Integer> winningNumber) {
        boolean passRange = winningNumber
                .stream()
                .allMatch(n -> n >= Const.LOTTO_START_NUM && n <= Const.LOTTO_END_NUM);
        boolean passLength = winningNumber.stream().distinct().count() == 6;
        if (passRange && passLength) {
            return true;
        }
        System.out.println(Const.INPUT_SIX_DISTINCT_NUMBER);
        return false;
    }

    public static int inputBuyPrice() {
        boolean pass = false;
        int inputIntPrice = 0;
        do {
            System.out.println(Const.INPUT_BUY_PRICE);
            try {
                inputIntPrice = scanner.nextInt();
                // Flush Buffer
                scanner.nextLine();
                pass = isPositiveNumber(inputIntPrice);
            } catch (InputMismatchException e) {
                System.out.println(Const.INPUT_INTEGER);
                // Flush Buffer
                scanner.nextLine();
            }
        } while (!pass);
        return inputIntPrice;
    }

    public static int inputBonusNumber(List<Integer> winningNumber) {
        boolean pass = false;
        int inputIntBonusNumber = 0;
        do {
            System.out.println(Const.INPUT_BONUS_NUMBER);
            try {
                inputIntBonusNumber = scanner.nextInt();
                // Flush Buffer
                scanner.nextLine();
                pass = isLottoBonusNumber(inputIntBonusNumber, winningNumber);
            } catch (InputMismatchException e) {
                System.out.println(Const.INPUT_INTEGER);
                // Flush Buffer
                scanner.nextLine();
            }
        } while (!pass);
        return inputIntBonusNumber;
    }


    private static boolean isPositiveNumber(int inputIntPrice) {
        if (inputIntPrice >= 0) {
            return true;
        }
        System.out.println(Const.INPUT_POSITIVE_INTEGER);
        return false;
    }


    private static boolean isLottoBonusNumber(int inputIntBonusNumber, List<Integer> winningNumber) {
        if (inputIntBonusNumber >= Const.LOTTO_START_NUM
                && inputIntBonusNumber <= Const.LOTTO_END_NUM
                && !winningNumber.contains(inputIntBonusNumber)) {
            return true;
        }
        System.out.println(Const.INPUT_LOTTO_BONUS_NUMBER);
        return false;
    }
}