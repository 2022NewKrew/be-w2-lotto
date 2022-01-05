package org.cs.finn.lotto.view;

import org.cs.finn.lotto.domain.LottoResult;
import org.cs.finn.lotto.domain.Lottos;
import org.cs.finn.lotto.domain.Money;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;
import org.cs.finn.lotto.domain.lotto.LottoPrize;

import java.util.Map;
import java.util.Objects;

public class LottoSimulatorView {

    public boolean checkNotEnoughMoney(final Money money) {
        if (Objects.requireNonNull(money).notEnoughToBuyOneLotto()) {
            System.out.println("로또 구매에 필요한 금액이 부족하므로 프로그램을 종료합니다.");
            return true;
        }
        return false;
    }

    public void printLottos(final Lottos lottos, final int manuals, final int autos) {
        Objects.requireNonNull(lottos);

        System.out.println("수동 " + manuals + "개, 자동 " + autos + "개를 구매했습니다.");

        for (LottoNumbers lottoNumbers : lottos.getList()) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void printResult(final LottoResult lottoResult, final Money money) {
        Objects.requireNonNull(lottoResult);
        Objects.requireNonNull(money);

        final Map<LottoPrize, Integer> mapCount = lottoResult.getMapCount();
        final Map<LottoPrize, Lottos> mapLottos = lottoResult.getMapLottos();
        long sumOfPrize = 0L;

        System.out.println("--- 추첨 결과 ---");
        for (LottoPrize lottoPrize : mapCount.keySet()) {
            System.out.println(lottoPrize + " - " + mapCount.get(lottoPrize) + "개");
            printWonLottos(lottoPrize, mapLottos.get(lottoPrize));

            sumOfPrize += mapCount.get(lottoPrize) * lottoPrize.getReward();
        }

        final double ret = (double)(sumOfPrize - money.getMoney()) / money.getMoney() * 100.0;
        System.out.printf("\n총 수익률은 %.2f%% 입니다.\n", ret);
    }

    private void printWonLottos(final LottoPrize lottoPrize, final Lottos lottos) {
        if (lottoPrize.isNone()) {
            return;
        }

        for (LottoNumbers lottoNumbers : lottos.getList()) {
            System.out.println(lottoNumbers);
        }
    }
}
