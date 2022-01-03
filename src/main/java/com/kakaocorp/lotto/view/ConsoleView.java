package com.kakaocorp.lotto.view;

import com.kakaocorp.lotto.controller.LottoGameConsoleController;
import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.dto.ResultResponse;

import java.util.Arrays;
import java.util.List;

public class ConsoleView {

    private static final LottoGameConsoleController lottoGameConsoleController = new LottoGameConsoleController();
    private static final List<Integer> scoreList = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    public void start() {
        List<Lotto> lottoList = lottoGameConsoleController.purchase();

        printPurchaseList(lottoList);
        printResult(lottoGameConsoleController.result(lottoList));
    }

    private void printResult(ResultResponse resultResponse) {
        System.out.println("당첨 통계\n---------");
        int[] result = resultResponse.getResult();
        for (int i = 3; i < result.length; i++) {
            System.out.println(i + 1 + "개 일치 (" + scoreList.get(i) + ")- " + result[i] + "개");
        }
        System.out.println("총 수익률은 " + resultResponse.getRateOfReturn() + "입니다.");
    }

    private void printPurchaseList(List<Lotto> purchaseList) {
        System.out.println(purchaseList.size() + "개를 구매했습니다.");
        purchaseList.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
