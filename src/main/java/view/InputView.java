package view;

import messages.GameMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner in = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(GameMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        int purchaseAmount = in.nextInt();
        in.nextLine(); // For Buffer
        return purchaseAmount;
    }

    public static List<Integer> inputLastWeekWinningNumber() {
        System.out.println(GameMessage.INPUT_LAST_WEEK_WINNING_NUMBER.getMessage());
        String input = in.nextLine();

        return Arrays.stream(input.split(","))
                .filter(str -> !str.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
    }
}
