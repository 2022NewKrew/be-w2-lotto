package com.kakao.lotto.step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResult {

    private int LOTTO_PRICE = 1000;
    private int THREE_PRIZE = 5000;
    private int FOUR_PRIZE = 50000;
    private int FIVE_PRIZE = 1500000;
    private int SIX_PRIZE = 2000000000;

    // results의 0번 인덱스는 3개 일치하는 로또의 개수, 1번 인덱스는 4개, 2번 인덱스는 5개, 3번 인덱스는 6개 일치하는 로또의 개수입니다.
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private List<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        makeResults();
    }

    // 각 lotto의 당첨 번호와 일치하는 수에 맞게 5results의 값을 변경해줍니다.
    private void makeResult(int sameNumber) {
        int index = sameNumber - 3;
        if(index < 0)
            return;
        results.set(index, results.get(index) + 1);
    }

    // lottos의 각각의 lotto를 가지고 results 값을 변경합니다.
    private void makeResults() {
        for(Lotto lotto : lottos) {
            int sameNumber = lotto.getSameNumber(winningNumbers);
            makeResult(sameNumber);
        }
    }

    // getter

    public List<Integer> getResults() {
        return results;
    }

    public int getProfitRate() {
        int profit = results.get(0) * THREE_PRIZE + results.get(1) * FOUR_PRIZE
                + results.get(2) * FIVE_PRIZE + results.get(3) * SIX_PRIZE;
        return (int) ((long)profit * 100 / (lottos.size() * LOTTO_PRICE));
    }

}
