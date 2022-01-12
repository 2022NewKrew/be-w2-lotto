package lotto.view;

import lotto.collections.LottoLine;
import lotto.domain.LottoPack;
import lotto.dto.InputLottoConfig;
import lotto.dto.LottoResults;
import lotto.utils.Rank;
import lotto.collections.RankMap;

import java.util.*;

public class Printer {

    private static final String aBuyNums = "%d개를 구매했습니다.";
    private static final String aResults = "당첨통계\n--------";
    private static final String aResultsPerNum = "%d개 일치 (%d원) - %d개";
    private static final String aResultsBonusMatch = "%d개 일치, 보너스볼 일치 (%d원) - %d개";
    private static final String aEarnRate = "총 수익률은 %d %%입니다.";
    private static final String aBuyNums2 = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";


    public static int printLottoCnt(int money){
        int lottoCnt = (int) (money / LottoPack.LOTTO_PRICE);
        System.out.println(String.format(aBuyNums, lottoCnt));
        return lottoCnt;
    }

    public static void printPurchasedLottos(InputLottoConfig inputLottoConfig, List<LottoLine> lottos){
        int manualCnt = inputLottoConfig.getManualLottoCnt();
        int totalCnt = inputLottoConfig.getTotalLottoCnt();
        int autoCnt = totalCnt - manualCnt;

        System.out.println(String.format(aBuyNums2, manualCnt,autoCnt));

        for(LottoLine lotto: lottos){
            System.out.println(lotto);
        }
    }



    public static void showResults(LottoResults lottoResults){
        RankMap rankMap = lottoResults.getRankMap();
        int earnRate = lottoResults.getEarnRate();
        showCorrectCnts(rankMap);
        showEarnRate(earnRate);
    }

    private static void showCorrectCnts(RankMap rankMap){
        System.out.println(aResults);
        for(Rank rank: rankMap.getKeySet()){
            showCorrectCntsPerLine(rank, rankMap.getValue(rank));
        }
    }



    private static void showCorrectCntsPerLine(Rank rank, int cnt){
        if (rank == Rank.SECOND){ //bonus number match
            System.out.println(String.format(aResultsBonusMatch, 5, rank.getWinningMoney(), cnt));
            return;
        }
        System.out.println(String.format(aResultsPerNum, rank.getCountOfMatch(), rank.getWinningMoney(), cnt));
    }

    public static void showEarnRate(int rate){
        System.out.println(String.format(aEarnRate, rate));
    }
}
