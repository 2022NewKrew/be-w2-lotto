package org.cs.finn.lotto.view;

import org.cs.finn.lotto.domain.Lottos;
import org.cs.finn.lotto.domain.LottoResult;
import org.cs.finn.lotto.domain.Money;
import org.cs.finn.lotto.domain.lotto.LottoNumbers;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;

public class LottoSimulatorView {

    public boolean checkNotEnoughMoney(final Money money) {
        if (Objects.requireNonNull(money).notEnoughToBuyOneLotto()) {
            System.out.println("로또 구매에 필요한 금액이 부족하므로 프로그램을 종료합니다.");
            return true;
        }
        return false;
    }

    public void buyLottos(
            final SecureRandom sRand,
            final Lottos lottos,
            final Money money
    )
    {
        Objects.requireNonNull(sRand);
        Objects.requireNonNull(money);

        final List<LottoNumbers> list = money.buyLottoAutoAll(sRand);
        System.out.println("자동 " + list.size() + "개를 구매했습니다.");

        for (LottoNumbers lottoNumbers : list) {
            System.out.println(lottoNumbers);
        }
        System.out.println();

        Objects.requireNonNull(lottos).addAll(list);
    }

    public void printResult(final LottoResult lottoResult, final Money money) {
        Objects.requireNonNull(lottoResult);
        Objects.requireNonNull(money);
    }
}
