package lotto.view;

import lotto.domain.LottoPaper;

import java.util.List;
import java.util.Map;

public class ViewLotto {

    public static void printLotto(List<LottoPaper> lottoPapers){
        for(LottoPaper lp : lottoPapers){
            System.out.println(lp.getPaper());
        }
        System.out.println();
    }

    public static void printResult(Map<Integer, Integer> lottoPrize, Map<Integer, Integer> result){
        System.out.println("당첨 통계");
        System.out.println("--------");
        for(int i=3;i<=6;i++){
            System.out.println(i+"개 일치 ("+lottoPrize.get(i)+"원) - "+result.get(i)+"개");
        }
    }

    public static void printPriceRatio(int ratio){
        System.out.println("총 수익률은 " + ratio + "%입니다.");
    }
}
