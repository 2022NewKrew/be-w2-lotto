package view;

import exceptions.InvalidLastWeekWinningNumber;
import messages.ErrorMessage;
import messages.GameMessage;
import validation.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner in = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(GameMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        return in.nextInt();
    }

    public static List<Integer> inputLastWeekWinningNumber() {
        System.out.println(GameMessage.INPUT_LAST_WEEK_WINNING_NUMBER.getMessage());
        in.nextLine(); // For Buffer
        String input = in.nextLine();

        return Arrays.stream(input.split(","))
                .filter(str -> !str.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .distinct()
                .peek((num) ->
                {
                    Validation.notLessThanInt(num, 1, new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_WINNING_NUMBER.getMessage()));
                    Validation.notMoreThanInt(num, 45, new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_WINNING_NUMBER.getMessage()));
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
