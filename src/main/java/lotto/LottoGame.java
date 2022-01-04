package lotto;


import lotto.domain.LottoGenerator;
import lotto.domain.LottoInput;
import lotto.domain.LottoPaper;
import lotto.view.ViewLotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private List<LottoPaper> lottoPapers;
    private List<Integer> preWeekNumber;
    private static final Map<Integer, Integer> LOTTO_PRIZE= Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );
    private final Map<Integer, Integer> rank = new HashMap<>(Map.of(
            6, 0,
            5, 0,
            4, 0,
            3, 0,
            2, 0,
            1, 0,
            0, 0
    ));

    public LottoGame() {}

    public void proceed(){
        LottoGenerator lg = new LottoGenerator(LottoInput.prePurchase());
        lg.generateLotto();
        lottoPapers = lg.getLottoPapers();

        ViewLotto.printLotto(lottoPapers);
        preWeekNumber = LottoInput.postPurchase();
        Collections.sort(preWeekNumber);

        searchResult();
        ViewLotto.printResult(LOTTO_PRIZE, rank);
        ViewLotto.printPriceRatio(calculatePrize(LottoInput.getInputPrice()));
    }

    private void searchResult(){
        int rankIdx;
        for(LottoPaper lp : lottoPapers){
            rankIdx = intersection(lp.getPaper());
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
        for(int i=3;i<6;i++){
            sum += LOTTO_PRIZE.get(i) * rank.get(i);
        }
        return sum / inputPrice * 100;
    }
}
