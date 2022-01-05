package be.w2.lotto.machines;

import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.view.input.Input;

import java.util.List;

/**
 * Singleton
 */
public class ManualPurchaseMachine extends PurchaseMachine {

    private static ManualPurchaseMachine INSTANCE;

    private ManualPurchaseMachine() {
    }

    public static ManualPurchaseMachine getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ManualPurchaseMachine();
        return INSTANCE;
    }

    @Override
    protected void addNewLottosTo(List<Lotto> lottos, int numOfLotto) {
        List<Lotto> inputLottos = Input.inputManualLottoNumbers(numOfLotto);
        lottos.addAll(inputLottos);
    }
}
