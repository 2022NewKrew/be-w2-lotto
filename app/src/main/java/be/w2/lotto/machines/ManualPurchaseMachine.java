package be.w2.lotto.machines;

import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.view.input.Input;

import java.util.List;

public class ManualPurchaseMachine extends PurchaseMachine {

    @Override
    protected void addNewLottosTo(List<Lotto> lottos, int numOfLotto) {
        List<Lotto> inputLottos = Input.inputManualLottoNumbers(numOfLotto);
        lottos.addAll(inputLottos);
    }
}
