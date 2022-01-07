package com.kakao.lotto.step3.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    public final static int LOTTO_PRICE = 1000;

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
        if(rank != null) {
            int countOfRank = results.get(rank);
            results.put(rank, countOfRank + 1);
        }
    }

    // lottos의 각각의 lotto를 가지고 results 값을 변경합니다.
    private void makeResults() {
        for(Lotto lotto : lottos) {
            int countOfMatch = lotto.getCountOfMatch(winningNumbers);
            boolean matchBonus = lotto.getMatchBonus(bonusNumber);
            makeResult(Rank.valueOf(countOfMatch, matchBonus));
        }
    }

    // getter

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public int getProfitRate() {
        int profit = Arrays.stream(Rank.values()).map(rank -> rank.getWinningMoney() * results.get(rank))
                .reduce(0, Integer::sum);
        return (int) ((long)profit * 100 / (lottos.size() * LOTTO_PRICE));
    }

}
