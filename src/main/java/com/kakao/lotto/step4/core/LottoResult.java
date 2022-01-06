package com.kakao.lotto.step4.core;

import java.util.*;

public class LottoResult {
    
    private int LOTTO_PRICE = 1000;

    private int bonusNumber;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Map<Rank, Integer> results = new HashMap<>();

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initResults();
        makeResults();
    }

    private void initResults() {
        Arrays.stream(Rank.values()).forEach(rank -> results.put(rank, 0));
    }

    private void makeResult(Rank rank) {
        if(rank != null)
            results.put(rank, results.get(rank) + 1);
    }

    // lottos의 각각의 lotto를 가지고 results 값을 변경합니다.
    private void makeResults() {
        for(Lotto lotto : lottos)
            makeResult(Rank.valueOf(lotto.getSameNumber(winningNumbers), lotto.hasBonusNumber(bonusNumber)));
    }

    public int getProfitRate() {
        int profit = Arrays.stream(Rank.values()).map(rank -> rank.getWinningMoney() * results.get(rank))
                .reduce(0, Integer::sum);
        return (int) ((long)profit * 100 / (lottos.size() * LOTTO_PRICE));
    }

    public String getResult(Rank rank) {
        String resultString = " ";
        if(rank == Rank.SECOND)
            resultString = ", 보너스 볼 일치";
        return String.format("%d개 일치%s(%d원)- %d개\n",
                rank.getCountOfMatch(), resultString, rank.getWinningMoney(), results.get(rank));
    }

    public Map<String, Object> getResults() {
        Map<String, Object> model = new HashMap<>();
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks) {
            model.put(rank.toString(), getResult(rank));
        }
        model.put("profit", getProfitRate());
        return model;
    }

}
