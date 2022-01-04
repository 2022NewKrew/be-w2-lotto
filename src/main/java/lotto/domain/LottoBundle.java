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
    private final Integer lottoCount;
    private final Integer manualLottoCount;
    private final List<Lotto> lottos;

    public LottoBundle(Integer lottoCount, Integer manualLottoCount) {
        this.lottoCount = lottoCount;
        this.manualLottoCount = manualLottoCount;

        lottos = new ArrayList<>();
        generateLottos(lottoCount, manualLottoCount);
    }

    private void generateLottos(Integer lottoCount, Integer manualLottoCount) {
        LottoPrinter.printManualLotto();
        for (int i = 0; i < manualLottoCount; i++) {
            List<Integer> manualLottoNumbers = LottoGenerator.generateManualLotto();
            lottos.add(new Lotto(manualLottoNumbers));
        }

        for (int i = 0; i < lottoCount - manualLottoCount; i++) {
            lottos.add(new Lotto(LottoGenerator.generateLotto()));
        }
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void printLottos() {
        LottoPrinter.printLottoAmount(manualLottoCount, lottoCount - manualLottoCount);
        lottos.forEach(System.out::println);
    }
}
