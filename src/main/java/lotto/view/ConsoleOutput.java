package lotto.view;

import lotto.service.domain.LottoGame;
import lotto.service.domain.LottoPrizeDetails;
import lotto.service.domain.LottoResult;
import lotto.service.domain.LottoTicket;
import lotto.util.LottoConstantValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleOutput {

    public void printPurchaedHistory(LottoGame lottoGame){
        List<LottoTicket> tickets = lottoGame.getLottoTickets();
        int numberOfAuto = (int) tickets.stream().filter(ticket -> ticket.isAuto()).count();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", tickets.size()-numberOfAuto, numberOfAuto);
        tickets.stream().forEach(LottoTicket::print);
    }

    public void printResult(LottoResult lottoResult){
        List<String> resultStrs = new ArrayList<>();

        System.out.println("\n당첨 통계\n---------");
        lottoResult.getWholeResult().forEach((resultStr, count)-> {
            if(resultStr != LottoPrizeDetails.NO_PRIZE )
                resultStrs.add(new String(resultStr + "- " + count + "개"));
        });
        Collections.sort(resultStrs);
        resultStrs.forEach(str -> System.out.println(str));
    }
    public void printProfit(LottoResult result){
        System.out.printf("총 수익률은 %2.0f%%입니다.\n", result.getYield());
    }

}
