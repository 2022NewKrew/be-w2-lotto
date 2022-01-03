package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinner;

import java.util.List;

import static lotto.domain.LottoSetting.LOTTO_LENGTH;

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

//        당첨 통계
//        ---------
//                3개 일치 (5000원)- 1개
//        4개 일치 (50000원)- 0개
//        5개 일치 (1500000원)- 0개
//        6개 일치 (2000000000원)- 0개
//        총 수익률은 30%입니다.

        System.out.println("당첨 통계\n---------");

        for(int correctCount = 3 ; correctCount <= LOTTO_LENGTH ; correctCount++){
            System.out.println(correctCount + "개 일치 - " + winnerList.get(correctCount).getWinner().size());
        }

    }
}
