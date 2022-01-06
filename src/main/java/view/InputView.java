package view;

import messages.GameMessage;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner in = new Scanner(System.in);

    public static long inputPurchaseAmount() {
        System.out.println(GameMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        long purchaseAmount = in.nextLong();
        in.nextLine(); // For Buffer
        return purchaseAmount;
    }

    public static Set<Integer> inputLastWeekWinningNumber() {
        System.out.println(GameMessage.INPUT_LAST_WEEK_WINNING_NUMBER.getMessage());
        String input = in.nextLine();

        return Arrays.stream(input.split(","))
                .filter(str -> !str.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .distinct()
                .boxed()
                .collect(Collectors.toSet());
    }
}
