package lotto;


import lotto.domain.LottoGenerator;
import lotto.domain.LottoInput;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.view.ViewLotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private List<LottoNumber> lottoNumbers;
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
        LottoGenerator lg = new LottoGenerator(LottoInput.prePurchase());
        lg.generateLotto();
        lottoNumbers = lg.getLottoPapers();

        ViewLotto.printLotto(lottoNumbers);
        preWeekNumber = LottoInput.postPurchase();
        bonusNumber = LottoInput.getBonusNumber();

        searchResult();
        ViewLotto.printResult(rank);
        ViewLotto.printPriceRatio(calculatePrize(LottoInput.getInputPrice()));
    }

    private void searchResult(){
        int countofMatch;
        boolean matchBonus;
        LottoRank lr;
        for(LottoNumber ln : lottoNumbers){
            countofMatch = intersection(ln.getNumbers());
            matchBonus = ln.getNumbers().contains(bonusNumber);
            lr = LottoRank.valueOf(countofMatch, matchBonus);
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

    private int calculatePrize(int inputPrice){
        int sum = 0;
        for(LottoRank lr : LottoRank.values()){
            int matchPrize = lr.getWinningPrize();
            int resultRank = lr.getResultRank();
            sum += matchPrize * rank.get(resultRank);
        }
        return sum / inputPrice * 100;
    }
}
