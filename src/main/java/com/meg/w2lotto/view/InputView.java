package com.meg.w2lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static final int askPurchaseMoney() {
        System.out.println("구입금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static final int askPurchaseManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public static final List<Integer> askPurchaseManualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return StrListToIntList(List.of(sc.next().split(",")));
    }

    public static final List<Integer> askLastLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return StrListToIntList(List.of(sc.next().split(",")));
    }

    private static final List<Integer> StrListToIntList(List<String> input) {
        List<Integer> list = new ArrayList<>();
        for (String c : input) {
            list.add(Integer.parseInt(c.strip()));
        }
        return list;
    }

    public static final int askBonusBallNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
