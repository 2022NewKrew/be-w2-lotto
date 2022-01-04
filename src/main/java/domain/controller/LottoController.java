package domain.controller;

import domain.ResultManager;
import domain.entity.Lotto;
import domain.PurchaseManager;
import domain.entity.WinningLotto;
import view.InputManager;

import java.util.*;

public class LottoController {
    public void start() {
        PurchaseManager purchaseManager = new PurchaseManager();
        List<Lotto> purchasedLottoList = purchaseManager.purchase();

        WinningLotto winningLotto = new WinningLotto();

        ResultManager resultManager = new ResultManager(winningLotto, purchasedLottoList);
        resultManager.getResult();
    }

}
