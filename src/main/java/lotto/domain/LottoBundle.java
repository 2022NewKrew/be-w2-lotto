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

    public LottoBundle(int lottoAmount) {
        this.lottoAmount = lottoAmount;
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(LottoGenerator.generateLotto()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void printLottos() {
        LottoPrinter.printLottoAmount(lottoAmount);
        lottos.forEach(System.out::println);
    }
}
