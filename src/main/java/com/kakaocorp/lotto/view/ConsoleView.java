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
        printResult(lottoGameConsoleController.result(lottoList));
    }

    private void printResult(ResultResponse resultResponse) {
        System.out.println("당첨 통계\n---------");
        List<Integer> result = resultResponse.getResult();
        for (int i = 3; i < result.size(); i++) {
            System.out.println(i + "개 일치 (" + ResultResponse.winningMoneyList.get(i) + "원)- " + result.get(i) + "개");
        }
        System.out.println("총 수익률은 " + resultResponse.getRateOfReturn() + "%입니다.");
    }

    private void printPurchaseList(List<Lotto> purchaseList) {
        System.out.println(purchaseList.size() + "개를 구매했습니다.");
        purchaseList.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
