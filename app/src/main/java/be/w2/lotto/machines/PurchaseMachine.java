package be.w2.lotto.machines;

import be.w2.lotto.cashier.Cashier;
import be.w2.lotto.lottos.Lotto;

import java.util.ArrayList;
import java.util.List;

public abstract class PurchaseMachine {

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int numOfLotto = Cashier.getNumOfLottoForPurchaseAmount(purchaseAmount);
        List<Lotto> lottos = getListOfLotto(purchaseAmount);
        addNewLottos(lottos, numOfLotto);
        return lottos;
    }

    protected List<Lotto> getListOfLotto(int numOfLotto) {
        return new ArrayList<>(numOfLotto);
    }

    protected abstract void addNewLottos(List<Lotto> lottos, int numOfLotto);
}
