package lotto;


import lotto.domain.*;
import lotto.util.LottoRank;
import lotto.view.ViewLotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private LottoPaper lp;
    private List<Integer> preWeekNumber;
    private int bonusNumber;
    private final Map<Integer, Integer> rank = new HashMap<>(Map.of(
            5, 0,
            4, 0,
            3, 0,
            2, 0,
            1, 0
    ));

    public LottoGame() {}


    public void proceed(){
        LottoPaper emptyLottoPaper = new LottoPaper();

        LottoInput li = new LottoInput(emptyLottoPaper);
        li.prePurchase();

        LottoGenerator lg = new LottoGenerator(li.getLottoPaper());
        lg.generateLotto(li.manualPurchase());
        lp = lg.getLottoPaper();

        ViewLotto.printLotto(lp);
        preWeekNumber = LottoInput.postPurchase();
        bonusNumber = LottoInput.getBonusNumber();

        searchResult();
        ViewLotto.printResult(rank);
        ViewLotto.printPriceRatio(calculatePrize(lp.inputPrice));
    }

    private void searchResult(){
        for(LottoNumber ln : lp.lottoNumbers){
            int countOfMatch = intersection(ln.getNumbers());
            boolean matchBonus = ln.getNumbers().contains(bonusNumber);
            LottoRank lr = LottoRank.valueOf(countOfMatch, matchBonus);
            updateRank(lr);
        }
    }

    private void updateRank(LottoRank lr){
        if(lr != null){
            int rankIdx = lr.getResultRank();
            rank.put(rankIdx, rank.get(rankIdx)+1);
        }
    }

    private int intersection(List<Integer> lottoPaper){
        Set<Integer> intSet = lottoPaper.stream()
                .distinct()
                .filter(preWeekNumber::contains)
                .collect(Collectors.toSet());
        return intSet.size();
    }

    private long calculatePrize(int inputPrice){
        long sum = 0;
        for(LottoRank lr : LottoRank.values()){
            int matchPrize = lr.getWinningPrize();
            int resultRank = lr.getResultRank();
            sum += (long) matchPrize * rank.get(resultRank);
        }
        return (sum-inputPrice) / inputPrice * 100;
    }
}
