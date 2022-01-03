package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinner;

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
    }

    public void printWinner(){
        List<LottoWinner> winnerList = lottoObject.getLottoWinner();

        System.out.println("당첨 통계\n---------");

        for(int correctCount = 3 ; correctCount <= LOTTO_LENGTH ; correctCount++){
            System.out.println(correctCount + "개 일치 (" + LOTTO_WINNER_PRIZE.get(correctCount) + "원)- " + winnerList.get(correctCount).getWinner().size() + "개");
        }
        System.out.println("총 수익률은 " + (getEarning().doubleValue() / getPayment() * 100) + "%입니다.");
    }

    private Long getPayment(){
        return Long.valueOf(lottoObject.getLottos().size() * LOTTO_PRICE) ;
    }

    private Long getEarning(){
        Long totalEarning = Long.valueOf(0);
        List<LottoWinner> winnerList = lottoObject.getLottoWinner();

        for(int correctCount = 0 ; correctCount <= LOTTO_LENGTH ; correctCount++){
            totalEarning += Long.valueOf(LOTTO_WINNER_PRIZE.get(correctCount)) * winnerList.get(correctCount).getWinner().size();
        }

        return totalEarning;
    }
}
