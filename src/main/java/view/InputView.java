package view;

import exceptions.InvalidManualTicketCount;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import messages.ErrorMessage;
import messages.GameMessage;
import validation.Validation;

public class InputView {

    private static final int MIN_COUNT = 0;
    private static final Scanner IN = new Scanner(System.in);

    public static long inputPurchaseAmount() {
        System.out.println(GameMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        long purchaseAmount = IN.nextLong();
        IN.nextLine(); // For Buffer
        return purchaseAmount;
    }

    public static int inputBonusNumber() {
        System.out.println(GameMessage.INPUT_BONUS.getMessage());
        int bonusNumber = IN.nextInt();
        IN.nextLine(); // For Buffer
        return bonusNumber;
    }

    private static int inputManualTicketCount() {
        System.out.println(GameMessage.INPUT_MANUAL_TICKET_COUNT.getMessage());
        int manualTicketCount = IN.nextInt();
        IN.nextLine(); // For Buffer
        return manualTicketCount;
    }

    public static Set<Integer> inputLastWeekWinningNumbers() {
        System.out.println(GameMessage.INPUT_LAST_WEEK_WINNING_NUMBER.getMessage());
        return lottoNumbers();
    }

    public static List<Set<Integer>> inputManualNumbers() {
        int count = inputManualTicketCount();
        Validation.notLessThanInt(count, MIN_COUNT,
                () -> new InvalidManualTicketCount(ErrorMessage.NEGATIVE_MANUAL_TICKET_COUNT.getMessage()));

        System.out.println(GameMessage.INPUT_MANUAL_NUMBER.getMessage());
        return Stream.generate(InputView::lottoNumbers)
                .limit(count)
                .collect(Collectors.toList());
    }

    private static Set<Integer> lottoNumbers() {
        String input = IN.nextLine();

        return Arrays.stream(input.split(","))
                .filter(str -> !str.isEmpty())
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
