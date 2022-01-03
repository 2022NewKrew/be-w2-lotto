package com.meg.w2lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static List<Integer> askLastLottoNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return StrListToIntList(List.of(sc.next().split(",")));
    }

    private static List<Integer> StrListToIntList(List<String> input) {
        List<Integer> list = new ArrayList<>();
        for (String c : input) {
            list.add(Integer.parseInt(c));
        }
        return list;
    }
}
