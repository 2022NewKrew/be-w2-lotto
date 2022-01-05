package be.w2.lotto.machines;

import be.w2.lotto.lottos.Lotto;

import java.util.ArrayList;
import java.util.List;

public abstract class PurchaseMachine {

    public List<Lotto> purchaseLottos(int numOfLotto) {
        List<Lotto> lottos = getListOfLotto(numOfLotto);
        addNewLottosTo(lottos, numOfLotto);
        return lottos;
    }

    protected List<Lotto> getListOfLotto(int numOfLotto) {
        return new ArrayList<>(numOfLotto);
    }

    protected abstract void addNewLottosTo(List<Lotto> lottos, int numOfLotto);
}
