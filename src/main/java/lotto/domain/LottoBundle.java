package lotto.domain;

import lotto.view.LottoPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 6:12
 */
public class LottoBundle {
    private final Integer lottoAmount;
    private final List<Lotto> lottos;
    private final Integer bonusBall;

    public LottoBundle(Integer lottoAmount, Integer bonusBall) {
        this.lottoAmount = lottoAmount;
        this.bonusBall = bonusBall;

        lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(LottoGenerator.generateLotto()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getBonusBall() {
        return bonusBall;
    }

    public void printLottos() {
        LottoPrinter.printLottoAmount(lottoAmount);
        lottos.forEach(System.out::println);
    }
}
