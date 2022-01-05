package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBER_OF_MANUAL_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTERIES_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner sc = new Scanner(System.in);

    private static int numberOfManual;

    private InputView() {
    }

    public static int inputTotalPrice() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        int totalPrice = sc.nextInt();
        sc.nextLine();
        System.out.println();
        return totalPrice;
    }

    public static int inputNumberOfManual() {
        System.out.println(INPUT_NUMBER_OF_MANUAL_MESSAGE);
        numberOfManual = sc.nextInt();
        sc.nextLine();
        System.out.println();
        return numberOfManual;
    }

    public static List<List<Integer>> inputManualLotteries() {
        System.out.println(INPUT_MANUAL_LOTTERIES_MESSAGE);
        List<List<Integer>> manualLotteries = new ArrayList<>();
        for (int i = 0; i < numberOfManual; i++) {
            String inputString = sc.nextLine();
            List<String> splitStrings = new ArrayList<>(Arrays.asList(inputString.split(", ")));
            List<Integer> manualNumbers = splitStrings.stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
            manualLotteries.add(manualNumbers);
        }
        System.out.println();
        return manualLotteries;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String inputString = sc.nextLine();
        List<String> splitStrings = new ArrayList<>(Arrays.asList(inputString.split(", ")));
        List<Integer> winningNumbers = splitStrings.stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        int bonusNumber = sc.nextInt();
        sc.nextLine();
        System.out.println();
        return bonusNumber;

    }
}
