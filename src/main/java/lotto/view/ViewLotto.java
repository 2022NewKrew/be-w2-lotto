package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPaper;
import lotto.util.LottoRank;

import java.util.Map;


/**
 * 출력과 관련된 메소드를 정리한 클래스
 */
public class ViewLotto {

    /**
     * 구매한 로또 번호 줄들을 출력하는 메소드
     * @param lp 로또 종이 한 장
     */
    public static void printLotto(LottoPaper lp){
        for(LottoNumbers ln : lp.lottoNumbers){
            System.out.println(ln.getNumbers());
        }
        System.out.println();
    }

    /**
     * 전체적인 당첨 통계를 출력하는 메소드
     * @param result 각 등수에 몇 번 당첨되었는지 들어있는 Map
     */
    public static void printResult(Map<Integer, Integer> result){
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("--------\n");
        for(LottoRank lr : LottoRank.values()){
            sb.append(printRank(lr, result));
        }
        System.out.print(sb);
    }

    /**
     * 현재 등 수의 세부 결과를 출력하는 메소드
     * @param lr 현재 등 수(LottoRank)
     * @param result 각 등수에 몇 번 당첨되었는지 들어있는 Map
     * @return 결과가 저장된 문자열
     */
    private static String printRank(LottoRank lr, Map<Integer, Integer> result){
        StringBuilder sb= new StringBuilder();
        sb.append(lr.getCountOfMatch() + "개 일치");
        if(lr.getResultRank() == 2){
            sb.append(", 보너스 불 일치");
        }
        sb.append("("+ lr.getWinningPrize() +"원) - " + result.get(lr.getResultRank()) + "개\n");
        return sb.toString();
    }

    /**
     * 총 수익률을 출력하는 메소드
     * @param ratio 수익률
     */
    public static void printPriceRatio(long ratio){
        System.out.println("총 수익률은 " + ratio + "%입니다.");
    }
}
