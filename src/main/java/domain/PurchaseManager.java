package domain;

import domain.entity.Lotto;
import view.InputManager;
import view.PrintManager;

import java.util.ArrayList;
import java.util.List;

public class PurchaseManager {
    public List<Lotto> purchase() {

        int numOfPurchasedLotto = purchaseAmount(InputManager.inputPurchaseAmount());
        PrintManager.printNumOfPurchasedLotto(numOfPurchasedLotto);

        List<Lotto> purchasedLottoList = purchaseLottos(numOfPurchasedLotto);
        PrintManager.printPuchasedLottoNums(purchasedLottoList);

        return purchasedLottoList;
    }

    public int purchaseAmount(int spentMoney) {
        return spentMoney / 1000;
    }
    public List<Lotto> purchaseLottos(int purchasedLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<purchasedLotto; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

}
