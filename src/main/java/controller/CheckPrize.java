package controller;

import domain.*;
import view.LottoOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPrize {

    private static final String NUMBER_SPLIT_REGEX = ",";
    final LottoPack lottoPack;
    final Lotto lottoPrize;

    public CheckPrize(LottoPack lottoPack, String prizeString){
        this.lottoPack = lottoPack;
        lottoPrize = parseLottoNumbers(prizeString);
        printPrize();
    }

    public WinningStats calculateWinningLottoStats(){
        RankingPack rankingPack = lottoPack.makeRankingPack(lottoPrize);
        WinningStats winningStats = rankingPack.makeWiningStats();
        return winningStats;
    }

    public void printPrize(){
        WinningStats winningStats = calculateWinningLottoStats();
        LottoOutput.printWinningStats(winningStats);
    }


    private Lotto parseLottoNumbers(String prizeString){
        String[] spt = prizeString.split(NUMBER_SPLIT_REGEX);
        List<Integer> prizeList = Arrays.stream(spt).map(Integer::parseInt).collect(Collectors.toList());
        return new Lotto(prizeList);
    }
}
