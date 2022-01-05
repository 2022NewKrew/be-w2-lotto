package domain;

import domain.entity.Lotto;
import view.InputManager;
import view.PrintManager;

import java.util.ArrayList;
import java.util.List;

import static domain.Const.PRICE_OF_LOTTO;

public class PurchaseManager {
    public List<Lotto> purchase() {
        int numOfPurchasedLotto = purchaseAmount(InputManager.inputPurchaseAmount());
        int numOfManualLotto = InputManager.inputManualAmount(numOfPurchasedLotto);

        List<Lotto> purchasedLottoList = purchaseManualLottos(numOfManualLotto);
        List<Lotto> autoLottoList = purchaseAutoLottos(numOfPurchasedLotto - numOfManualLotto);
        purchasedLottoList.addAll(autoLottoList);

        PrintManager.printPurchasedLottoNums(numOfManualLotto, purchasedLottoList);

        return purchasedLottoList;
    }

    public int purchaseAmount(int spentMoney) {
        return spentMoney / PRICE_OF_LOTTO;
    }
    public List<Lotto> purchaseManualLottos(int numOfManualLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> manualLottoList = new ArrayList<>();
        for(int i=0; i<numOfManualLotto; i++) {
            Lotto lotto = new Lotto(InputManager.inputLottoNums());
            manualLottoList.add(lotto);
        }

        return manualLottoList;
    }

    public List<Lotto> purchaseAutoLottos(int purchasedLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<purchasedLotto; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

}
