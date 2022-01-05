package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.dto.OutputDTO;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoSetting.*;

public class LottoViewOutput {
    public LottoViewOutput(){}

    public void printLottoCount(OutputDTO outputDTO){
        System.out.println(outputDTO.getLottos().size() + "개를 구매했습니다.");
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

    public void printAllLottos(OutputDTO outputDTO){
        for(int i = 0 ; i < outputDTO.getLottos().size() ; i++){
            printLotto(outputDTO.getLottos().get(i));
        }
        System.out.print("\n");
    }

    public void printWinner(OutputDTO outputDTO){
        Map<Rank, List<LottoNumber>> winnerMap = outputDTO.getLottoWinner();

        System.out.println("\n당첨 통계\n---------");

        List<Rank> ranks = List.of(Rank.values());
        for(int i = ranks.size() - 1 ; i >= 0 ; i--){
            if(ranks.get(i).getCountOfMatch() < Rank.FOURTH.getCountOfMatch()){
                continue;
            }
            System.out.println(ranks.get(i).getCountOfMatch() + "개 일치 " + ranks.get(i).getWinningMessage() + " - " + winnerMap.get(ranks.get(i)).size() + "개");
        }

        System.out.println("총 수익률은 " + Long.valueOf((long) (outputDTO.getEarning().doubleValue() / outputDTO.getPayment() * 100)) + "%입니다.");
    }
}
