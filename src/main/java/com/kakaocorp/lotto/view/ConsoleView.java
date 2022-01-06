package com.kakaocorp.lotto.view;

import com.kakaocorp.lotto.controller.LottoGameConsoleController;
import com.kakaocorp.lotto.dto.BuyLottoDto;
import com.kakaocorp.lotto.dto.ResultResponse;
import com.kakaocorp.lotto.enums.Grade;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class ConsoleView {

    private static final LottoGameConsoleController lottoGameConsoleController = new LottoGameConsoleController();

    public void start() {
        try {
            // 로또 구매
            BuyLottoDto buyLottoDto = lottoGameConsoleController.buy();
            printBuyList(buyLottoDto);

            // 당첨 통계
            printResults(lottoGameConsoleController.result(buyLottoDto.getLottoList()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            start();
        }
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

    private void printBuyList(BuyLottoDto buyLottoDto) {
        int orderAutoNumber = buyLottoDto.getLottoList().size() - buyLottoDto.getOrderManualNumber();
        System.out.println("수동으로 " + buyLottoDto.getOrderManualNumber() + "장, 자동으로 " + orderAutoNumber + "개를 구매했습니다.");
        buyLottoDto.getLottoList().forEach(lotto -> System.out.println(lotto.toString()));
    }
}
