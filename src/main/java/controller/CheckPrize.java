package controller;

import domain.*;
import view.LottoOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPrize {
    private static final String NUMBER_SPLIT_REGEX = ",";

    public CheckPrize() {

    }

    private static WinningStats calculateWinningLottoStats(LottoPack lottoPack, String prizeString,int bonus) {
        Lotto lottoPrize = parseLottoNumbers(prizeString);
        RankingPack rankingPack = lottoPack.makeRankingPack(lottoPrize,bonus);
        return rankingPack.makeWiningStats();
    }

    public static void printPrize(LottoPack lottoPack, String prizeString, int bonus) {
        WinningStats winningStats = calculateWinningLottoStats(lottoPack, prizeString,bonus);
        LottoOutput.printWinningStats(winningStats,lottoPack.getBuyPrice());
    }

    private static Lotto parseLottoNumbers(String prizeString) {
        String[] spt = prizeString.split(NUMBER_SPLIT_REGEX);
        List<Integer> prizeList = Arrays.stream(spt).map(Integer::parseInt).collect(Collectors.toList());
        return new Lotto(prizeList);
    }

}
