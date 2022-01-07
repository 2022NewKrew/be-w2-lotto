package lotto.controller;


import lotto.domain.*;
import lotto.util.LottoRank;
import lotto.view.ViewLotto;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 전반적인 로또 게임을 진행하는 클래스
 */
public class LottoController {
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

    public LottoController() {}


    /**
     * 로또 게임을 진행하는 메소드
     */
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

    /**
     * 각각의 로또 줄을 확인하며, 일치하는 번호 수, 보너스 볼 당첨 여부를 파악하여 업데이트하는 메소드
     */
    private void searchResult(){
        for(LottoNumbers ln : lp.lottoNumbers){
            int countOfMatch = intersection(ln.getNumbers());
            boolean matchBonus = ln.getNumbers().contains(bonusNumber);
            LottoRank lr = LottoRank.valueOf(countOfMatch, matchBonus);
            updateRank(lr);
        }
    }

    /**
     * 확인된 랭크에 당첨 횟수를 추가하는 메소드
     * @param lr 확인된 LottoRank
     */
    private void updateRank(LottoRank lr){
        if(lr != null){
            int rankIdx = lr.getResultRank();
            rank.put(rankIdx, rank.get(rankIdx)+1);
        }
    }


    /**
     * 교집합을 통해 일치하는 숫자 수를 확인하는 메소드
     * @param lottoPaper 로또 한 줄
     * @return 당첨 번호와 일치하는 숫자 수
     */
    private int intersection(List<Integer> lottoPaper){
        Set<Integer> intSet = lottoPaper.stream()
                .distinct()
                .filter(preWeekNumber::contains)
                .collect(Collectors.toSet());
        return intSet.size();
    }

    /**
     * 수익률을 계산하는 메소드
     * @param inputPrice 구매 금액
     * @return 수익률
     */
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
