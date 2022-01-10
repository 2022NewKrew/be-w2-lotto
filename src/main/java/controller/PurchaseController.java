package controller;

import constant.LottoConstants;
import domain.Lotto;
import service.PurchaseLottoService;

import java.util.ArrayList;
import java.util.List;

public class PurchaseController {
    private PurchaseLottoService purchaseLottoService;

    public PurchaseController() {
        this.purchaseLottoService = new PurchaseLottoService();
    }

    public List<Lotto> purchaseManualLotto(List<String> manualLottoStringList) {
        List<Lotto> manualLottoList = new ArrayList<>();
        for (String manualLottoString : manualLottoStringList) {
            manualLottoList.add(purchaseLottoService.purchaseManualLotto(manualLottoString));
        }
        return manualLottoList;
    }

    public List<Lotto> purchaseRandomLotto(int money, int manualAmount) {
        List<Lotto> randomLottoList = new ArrayList<>();
        int randomAmount = money / LottoConstants.LOTTO_PRICE - manualAmount;
        for (int i = 0 ; i < randomAmount ; i++) {
            Lotto purchasedLotto = purchaseLottoService.purchaseRandomLotto();
            randomLottoList.add(purchasedLotto);
        }
        return randomLottoList;
    }


}
