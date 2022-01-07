package com.kakao.lotto.step3.view;

import com.kakao.lotto.step3.core.Lotto;

import java.util.List;

public class LottoPrinter {

    // lotto들을 출력해줍니다.
    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    // 구매한 로또의 개수를 출력해줍니다.
    public void printBuyLottoCount(int lottoCount, int manualLottoCount) {
        int randomLottoCount = lottoCount - manualLottoCount;
        System.out.println(String.format("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                manualLottoCount, randomLottoCount));
    }

}
