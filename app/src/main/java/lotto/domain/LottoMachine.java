package lotto.domain;

import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.ManualLottoGenerator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  LottoMachine 객체를 통해 로또를 구매할 수 있습니다.
 *  LottoGenerator 객체를 이용해 로또를 생성해 lottoList에 추가해줍니다.
 */
public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private static final LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
    private static final LottoGenerator manualLottoGenerator = new ManualLottoGenerator();
    private static LottoMachine INSTANCE;

    private LottoMachine() {
    }

    public static synchronized LottoMachine getInstance() {
        if (INSTANCE == null) {
            LottoGenerator.initNumbers();
            INSTANCE = new LottoMachine();
        }
        return INSTANCE;
    }

    public void buyAutoLotto(List<Lotto> lottoList, int purchasePrice) {
        final int numberOfAutoLotto = purchasePrice / LOTTO_PRICE; // 구매할 자동 로또 개수

        for (int i = 0; i < numberOfAutoLotto; i++) { // 자동 구매
            lottoList.add(autoLottoGenerator.generate());
        }
    }

    public void buyManualLotto(List<Lotto> lottoList, int numberOfManualLotto) {
        for (int i = 0; i < numberOfManualLotto; i++) { // 수동 구매
            lottoList.add(manualLottoGenerator.generate());
        }
    }
}
