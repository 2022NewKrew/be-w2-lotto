package com.kakao.lotto.step1.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResult {

    // results의 0번 인덱스는 3개 일치하는 로또의 개수, 1번 인덱스는 4개, 2번 인덱스는 5개, 3번 인덱스는 6개 일치하는 로또의 개수입니다.
    private int price;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private List<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0, 0));

    public LottoResult(int price, List<Lotto> lottos, List<Integer> winningNumbers) {
        this.price = price;
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        makeResults();
    }

    // 각 lotto의 당첨 번호와 일치하는 수에 맞게 results의 값을 변경해줍니다.
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

    public int getPrice() {
        return price;
    }

}
