package com.kakao.lotto.step1.view;

import com.kakao.lotto.step1.domain.Lotto;

import java.util.List;

public class LottoPrinter {

    private List<Lotto> lottos;

    public LottoPrinter(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    // lotto들을 출력해줍니다.
    public void printLottos() {
        for(int i = 0; i < lottos.size(); i++)
            System.out.println(lottos.get(i).getLotto());
    }
}
