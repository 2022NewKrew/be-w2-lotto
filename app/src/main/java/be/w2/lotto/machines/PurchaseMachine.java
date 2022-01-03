package be.w2.lotto.machines;

import be.w2.lotto.cashier.Cashier;

import java.util.ArrayList;
import java.util.List;

public abstract class PurchaseMachine {

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        List<Lotto> lottos = getListOfLotto(purchaseAmount);
        addNewLottos(lottos);
        return lottos;
    }

    protected List<Lotto> getListOfLotto(int purchaseAmount) {
        int numOfLotto = Cashier.getNumOfLottoForPurchaseAmount(purchaseAmount);
        return new ArrayList<>(numOfLotto);
    }

    protected abstract void addNewLottos(List<Lotto> lottos);
}
