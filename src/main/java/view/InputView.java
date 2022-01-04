package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
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
        String[] splitStrings = inputString.split(", ");
        System.out.println();

        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitString : splitStrings) {
            winningNumbers.add(Integer.valueOf(splitString));
        }
        return winningNumbers;
    }
}

