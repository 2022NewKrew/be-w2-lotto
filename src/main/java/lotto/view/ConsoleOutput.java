package lotto.view;

import lotto.service.domain.LottoResult;
import lotto.util.LottoConstantValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleOutput {

    public void printResult(LottoResult lottoResult){
        List<String> resultStrs = new ArrayList<>();

        System.out.println("\n당첨 통계\n---------");
        lottoResult.getWholeResult().forEach((resultStr, count)-> resultStrs.add(new String(resultStr + "- " + count + "개")));
        Collections.sort(resultStrs);
        resultStrs.forEach(str -> System.out.println(str));
    }
    public void printProfit(long budget, long prizeMoney){
        final double purchasedMoney = ((long)(budget/ LottoConstantValue.LOTTO_PRICE)*LottoConstantValue.LOTTO_PRICE);
        final double profit = (double) (prizeMoney - budget) / (double)(budget) * 100;
        System.out.printf("총 수익률은 %2.0f%%입니다.\n",profit);
        System.out.println(prizeMoney);
    }

}
