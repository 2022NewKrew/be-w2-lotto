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
    private final int lottoCount;
    private final int manualLottoCount;
    private final List<Lotto> lottos;

    public LottoBundle(int purchaseAmount, int manualLottoCount) {
        Validator.validatePurchaseAmount(purchaseAmount);

        this.lottoCount = purchaseAmount / Constants.LOTTO_PRICE;
        this.manualLottoCount = manualLottoCount;
        Validator.validateManualLottoCount(lottoCount, manualLottoCount);

        lottos = new ArrayList<>();
        generateLottos(lottoCount, manualLottoCount);
    }

    private void generateLottos(int lottoCount, int manualLottoCount) {
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
