package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.PlayerLottoList;

import java.util.List;

public class LottoGameOutput {

    public static void printLottoNumbers(int numberOfLotto, PlayerLottoList playerLottoList) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        playerLottoList.getLottoList().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printLottoResults(List<LottoResult> lottoResults, long rewardRate) {
        System.out.println("\n당첨 통계\n--------");
        lottoResults.forEach(LottoGameOutput::printOneLottoResult);
        System.out.println("총 수익률은 " + rewardRate + "%입니다.");
    }

    public static void printOneLottoResult(LottoResult lottoResult) {
        if(lottoResult.rank == LottoRank.BLANK) return;

        StringBuilder sb = new StringBuilder();
        sb.append(lottoResult.rank.getMatchingCnt()).append("개 일치 ");
        if(lottoResult.rank.isBonus()) sb.append(",보너스 볼 일치");
        sb.append("(").append(lottoResult.rank.getReward()).append("원)- ")
                .append(lottoResult.numberOfWinningLotteryPaper).append("개");
        System.out.println(sb);
    }
}

