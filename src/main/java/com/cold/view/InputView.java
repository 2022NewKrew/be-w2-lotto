package com.cold.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static String INPUT_PURCHASE_PRICE = "구매금액을 입력해 주세요.";
    private static String INPUT_LAST_WINNING_NUMS = "지난 주 당첨 번호를 입력해 주세요.";
    private static String INVALID_PURCHASED_PRICE = "구입 금액이 음수일 수는 없습니다.";
    private static String INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int purchase() throws Exception {
        System.out.println(INPUT_PURCHASE_PRICE);
        int purchasedPrice = scanner.nextInt();
        validatePurchasedPrice(purchasedPrice);
        int purchasedCount = calculateCount(purchasedPrice);
        return purchasedCount;
    }

    private static void validatePurchasedPrice(int purchasedPrice) throws Exception {
        if (purchasedPrice < 0) {
            throw new Exception(INVALID_PURCHASED_PRICE);
        }
    }

    private static int calculateCount(int purchasedPrice) {
        return purchasedPrice / 1000;
    }

    public static List<Integer> inputLastWinningNums() throws Exception {
        System.out.println(INPUT_LAST_WINNING_NUMS);
        String lastWinningNumsString = scanner.next();
        List<Integer> lastWinningNums = parseLastWinningNums(lastWinningNumsString);
        return lastWinningNums;
    }

    private static List<Integer> parseLastWinningNums(String lastWinningNumsString) throws Exception {
        List<Integer> lastWinningNums = new ArrayList<>();
        for (String num : lastWinningNumsString.split(",")) {
            num.trim();
            lastWinningNums.add(Integer.parseInt(num));
        }
        return lastWinningNums;
    }

    public static int inputBonusBall() throws Exception {
        System.out.println(INPUT_BONUS_BALL);
        int bonusBall = scanner.nextInt();
        return bonusBall;
    }
}
