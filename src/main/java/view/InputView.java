package view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import messages.GameMessage;

public class InputView {

    private static final Scanner in = new Scanner(System.in);

    public static long inputPurchaseAmount() {
        System.out.println(GameMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        long purchaseAmount = in.nextLong();
        in.nextLine(); // For Buffer
        return purchaseAmount;
    }

    public static int inputBonusNumber() {
        System.out.println(GameMessage.INPUT_BONUS.getMessage());
        int bonusNumber = in.nextInt();
        in.nextLine(); // For Buffer
        return bonusNumber;
    }

    public static Set<Integer> inputLastWeekWinningNumber() {
        System.out.println(GameMessage.INPUT_LAST_WEEK_WINNING_NUMBER.getMessage());
        String input = in.nextLine();

        return Arrays.stream(input.split(","))
                .filter(str -> !str.isEmpty())
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
