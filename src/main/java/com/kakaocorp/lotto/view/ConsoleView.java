package com.kakaocorp.lotto.view;

import com.kakaocorp.lotto.controller.LottoGameConsoleController;
import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.dto.ResultResponse;

import java.util.List;

public class ConsoleView {

    private static final LottoGameConsoleController lottoGameConsoleController = new LottoGameConsoleController();

    public void start() {
        // 로또 구매
        List<Lotto> lottoList = lottoGameConsoleController.purchase();
        printPurchaseList(lottoList);

        // 당첨 통계
        printResults(lottoGameConsoleController.result(lottoList));
    }

    private void printResults(ResultResponse resultResponse) {
        System.out.println("당첨 통계\n---------");
        List<Integer> results = resultResponse.getResults();
        for (int i = 3; i < results.size()-1; i++) {
            printResult(results, i);
        }
        System.out.println("총 수익률은 " + String.format("%.2f", resultResponse.getRateOfReturn()) + "%입니다.");
    }

    private void printResult(List<Integer> results, int i) {
        System.out.println(i + "개 일치 (" + ResultResponse.winningMoneyList.get(i) + "원)- " + results.get(i) + "개");

        if (i == 5) {
            System.out.println("5개 일치, 보너스 볼 일치(" + ResultResponse.winningMoneyList.get(7) + "원)- " + results.get(7) + "개");
        }
    }

    private void printPurchaseList(List<Lotto> purchaseList) {
        System.out.println(purchaseList.size() + "개를 구매했습니다.");
        purchaseList.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
