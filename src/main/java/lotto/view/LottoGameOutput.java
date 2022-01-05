package lotto.view;

import lotto.domain.result.LottoRank;
import lotto.domain.result.LottoResult;
import lotto.domain.player.PlayerLottoList;

import java.util.List;

public class LottoGameOutput {

    public static void printLottoNumbers(int numberOfManualLotto, int numberOfAutoLotto, PlayerLottoList playerLottoList) {
        System.out.print("수동으로 " + numberOfManualLotto + "장,");
        System.out.println("자동으로 " + numberOfAutoLotto + "장을 구매했습니다.");
        playerLottoList.getPlayerLottoList().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printLottoResults(List<LottoResult> lottoResults, long rewardRate) {
        System.out.println("\n당첨 통계\n--------");
        lottoResults.forEach(LottoGameOutput::printOneLottoResult);
        System.out.println("총 수익률은 " + rewardRate + "%입니다.");
    }

    public static void printOneLottoResult(LottoResult lottoResult) {
        if(lottoResult.rank == LottoRank.BLANK) return;

        StringBuilder sb = new StringBuilder();
        sb.append(lottoResult.rank.getMatchingCnt()).append("개 일치");
        if(lottoResult.rank.isBonus()) sb.append(", 보너스 볼 일치");
        sb.append(" (").append(lottoResult.rank.getReward()).append("원)- ")
                .append(lottoResult.numberOfWinningLotteryPaper).append("개");
        System.out.println(sb);
    }

    public static void printInputManualLottoComment(){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
}

