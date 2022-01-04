package view;

import domain.UIMessage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static long inputMoney() {
        System.out.println(UIMessage.HOW_MONEY.getMessage());
        long money;
        try {
            String input = scanner.nextLine();
            money = Long.parseLong(input);
        } catch (Exception e) {
            money = 0;
        }
        return money;
    }

    public static List<Integer> inputWinningNum() {
        System.out.println(UIMessage.LAST_WINNING_NUM.getMessage());
        String input = scanner.nextLine();

        String replace = input.replace(" ", "");

        return Arrays.stream(replace.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNum() {
        System.out.println(UIMessage.BONUS_NUM.getMessage());
        int bonus;
        try {
            String input = scanner.nextLine();
            bonus = Integer.parseInt(input);
        } catch (Exception e) {
            bonus = -1;
        }
        return bonus;
    }

    public static void outputLotto(int count, String lotto) {
        System.out.printf(UIMessage.BUY_RESULT.getMessage(), count);
        System.out.println(lotto);
    }

    public static void outputWinningResult(HashMap<Integer, Integer> winningResult, int winRate) {
        System.out.printf(UIMessage.WINNING_RESULT.getMessage(), winningResult.get(3), winningResult.get(4), winningResult.get(5), winningResult.get(6), winRate);
    }
}
