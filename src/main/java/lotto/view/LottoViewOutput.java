package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinner;
import lotto.domain.Rank;

import java.util.List;

import static lotto.domain.LottoSetting.*;

public class LottoViewOutput {
    Lotto lottoObject;
    public LottoViewOutput(Lotto lottoObject){
        this.lottoObject = lottoObject;
    }

    public void printLottoCount(){
        System.out.println(lottoObject.getLottos().size() + "개를 구매했습니다.");
    }

    private void printLotto(LottoNumber singleLotto){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0 ; i < singleLotto.num.size() ; i++){
            sb.append( singleLotto.num.get(i) + (i + 1 < singleLotto.num.size() ? ", " : "")  );
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void printAllLottos(){
        for(int i = 0 ; i < lottoObject.getLottos().size() ; i++){
            printLotto(lottoObject.getLottos().get(i));
        }
        System.out.print("\n");
    }

    public void printWinner(){
        List<LottoWinner> winnerList = lottoObject.getLottoWinner();

        System.out.println("\n당첨 통계\n---------");

        for(int correctCount = 3 ; correctCount <= LOTTO_LENGTH ; correctCount++){
            System.out.println(correctCount + "개 일치 " + Rank.getRankByCount(correctCount, false).getWinningMessage() + " - " + winnerList.get(correctCount).getWinner().size() + "개");
        }
        System.out.println("총 수익률은 " + Long.valueOf((long) (lottoObject.getEarning().doubleValue() / lottoObject.getPayment() * 100)) + "%입니다.");
    }
}
