package controller;

import domain.*;
import view.LottoOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPrize {
    private static final String NUMBER_SPLIT_REGEX = ",";
    public CheckPrize(){

    }

    public static WinningStats calculateWinningLottoStats(LottoPack lottoPack, String prizeString){
        Lotto lottoPrize = parseLottoNumbers(prizeString);
        RankingPack rankingPack = lottoPack.makeRankingPack(lottoPrize);
        return rankingPack.makeWiningStats();
    }

    public static void printPrize(LottoPack lottoPack,String prizeString ){
        WinningStats winningStats = calculateWinningLottoStats(lottoPack,prizeString);
        LottoOutput.printWinningStats(winningStats);
    }


    private static Lotto parseLottoNumbers(String prizeString){
        String[] spt = prizeString.split(NUMBER_SPLIT_REGEX);
        List<Integer> prizeList = Arrays.stream(spt).map(Integer::parseInt).collect(Collectors.toList());
        return new Lotto(prizeList);
    }
}
