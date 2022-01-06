package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoPaper;
import lotto.util.LottoRank;

import java.util.Map;

public class ViewLotto {

    public static void printLotto(LottoPaper lp){
        for(LottoNumber ln : lp.lottoNumbers){
            System.out.println(ln.getNumbers());
        }
        System.out.println();
    }

    public static void printResult(Map<Integer, Integer> result){
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("--------\n");
        for(LottoRank lr : LottoRank.values()){
            sb.append(printRank(lr, result));
        }
        System.out.print(sb);
    }

    private static String printRank(LottoRank lr, Map<Integer, Integer> result){
        StringBuilder sb= new StringBuilder();
        sb.append(lr.getCountOfMatch() + "개 일치");
        if(lr.getResultRank() == 2){
            sb.append(", 보너스 불 일치");
        }
        sb.append("("+ lr.getWinningPrize() +"원) - " + result.get(lr.getResultRank()) + "개\n");
        return sb.toString();
    }

    public static void printPriceRatio(long ratio){
        System.out.println("총 수익률은 " + ratio + "%입니다.");
    }
}
