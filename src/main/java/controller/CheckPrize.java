package controller;

import domain.*;
import view.LottoOutput;

public class CheckPrize {

    public CheckPrize() {

    }

    private static WinningStats calculateWinningLottoStats(LottoPack lottoPack, String winingTicketString, int bonus) {
        RankingPack rankingPack = lottoPack.makeRankingPack(new Lotto(winingTicketString), bonus);
        return rankingPack.makeWiningStats();
    }

    public static void printPrize(LottoPack lottoPack, String prizeString, int bonus) {
        WinningStats winningStats = calculateWinningLottoStats(lottoPack, prizeString, bonus);
        LottoOutput.printWinningStats(winningStats, lottoPack.getBuyPrice());
    }


}
