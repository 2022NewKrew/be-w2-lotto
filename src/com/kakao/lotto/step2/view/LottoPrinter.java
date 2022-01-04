package com.kakao.lotto.step2.view;

import com.kakao.lotto.step2.domain.Lotto;

import java.util.List;

public class LottoPrinter {

    // lotto들을 출력해줍니다.
    public void printLottos(List<Lotto> lottos) {
        for(int i = 0; i < lottos.size(); i++)
            System.out.println(lottos.get(i).getLotto());
    }

    // 구매한 로또의 개수를 출력해줍니다.
    public void printBuyLottoNumber(int lottoNumber) {
        System.out.println(lottoNumber + "개를 구매했습니다.");
    }

}
