package com.cold.view;

import com.cold.domain.SingleTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static String INPUT_PURCHASE_PRICE = "구매금액을 입력해 주세요.";
    private static String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static String INPUT_MANUAL_LOTTO_NUMBER_SET = "수동으로 구매할 번호를 입력해 주세요.";
    private static String INPUT_LAST_WINNING_NUMS = "지난 주 당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_PRICE);
        int purchaseMoney = Integer.parseInt(scanner.nextLine());
        return purchaseMoney;
    }

    public static List<SingleTicket> inputManualLottoNumbers(int manualLottoCount) {
        List<SingleTicket> manualLotto;
        manualLotto = inputWholeManualLottoNumbers(manualLottoCount);
        return manualLotto;
    }

    private static List<SingleTicket> inputWholeManualLottoNumbers(int manualLottoCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_SET);
        List<SingleTicket> wholeManualLotto = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            List<Integer> manualNumberSet = inputNumberSet();
            wholeManualLotto.add(new SingleTicket(manualNumberSet));
        }
        return wholeManualLotto;
    }

    private static List<Integer> inputNumberSet() {
        String numberSetString = scanner.nextLine();
        List<Integer> numberSet = parseNumberSet(numberSetString);
        return numberSet;
    }

    public static List<Integer> inputLastWinningNums() {
        System.out.println(INPUT_LAST_WINNING_NUMS);
        String lastWinningNumsString = scanner.nextLine();
        List<Integer> lastWinningNums = parseNumberSet(lastWinningNumsString);
        return lastWinningNums;
    }

    private static List<Integer> parseNumberSet(String numberSetString) {
        List<Integer> numberSet = new ArrayList<>();
        for (String num : numberSetString.split(",")) {
            numberSet.add(Integer.parseInt(num.trim()));
        }
        return numberSet;
    }

    public static int inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL);
        int bonusBall = Integer.parseInt(scanner.nextLine());
        return bonusBall;
    }

    public static int inputManualPurchaseCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT);
        int manualLottoCount = Integer.parseInt(scanner.nextLine());
        return manualLottoCount;
    }

}
