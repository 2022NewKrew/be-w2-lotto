package com.kakaocorp.lotto.view;

import com.kakaocorp.lotto.controller.LottoGameConsoleController;
import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.dto.ResultResponse;
import com.kakaocorp.lotto.enums.Grade;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ConsoleView {

    private static final LottoGameConsoleController lottoGameConsoleController = new LottoGameConsoleController();

    public void start() {
        // 로또 구매
        List<Lotto> lottoList = lottoGameConsoleController.buy();
        printPurchaseList(lottoList);

        // 당첨 통계
        printResults(lottoGameConsoleController.result(lottoList));
    }

    private void printResults(ResultResponse resultResponse) {
        System.out.println("당첨 통계\n---------");
        Map<Grade, Integer> results = resultResponse.getResults();

        Grade[] mapKey = results.keySet().toArray(new Grade[0]);
        Arrays.sort(mapKey, Collections.reverseOrder());
        Arrays.stream(mapKey).forEach(x -> printResult(x, results.get(x)));

        System.out.println("총 수익률은 " + String.format("%.2f", resultResponse.getRateOfReturn()) + "%입니다.");
    }

    private void printResult(Grade key, Integer value) {
        if (key == Grade.NO_GRADE) {
            return;
        }

        if (key.getMatchIndex() == 7) {
            System.out.println("5개 일치, 보너스 볼 일치(" + key.getWinningMoney() + "원)- " + value + "개");
            return;
        }

        System.out.println(key.getMatchIndex() + "개 일치 (" + key.getWinningMoney() + "원)- " + value + "개");
    }

    private void printPurchaseList(List<Lotto> purchaseList) {
        System.out.println(purchaseList.size() + "개를 구매했습니다.");
        purchaseList.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
