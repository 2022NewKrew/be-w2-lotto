package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static Scanner sc = new Scanner(System.in);

    public static int inputTotalPrice() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        int totalPrice = sc.nextInt();
        sc.nextLine();
        return totalPrice;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String inputString = sc.nextLine();
        List<String> splitStrings = new ArrayList<>(Arrays.asList(inputString.split(", ")));
        System.out.println();

        List<Integer> winningNumbers = new ArrayList<>(splitStrings
                                                               .stream()
                                                               .map(Integer::valueOf)
                                                               .sorted()
                                                               .collect(Collectors.toList()));

        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        return bonusNumber;

    }
}
