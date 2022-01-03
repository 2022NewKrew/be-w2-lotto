package domain.controller;

import domain.ResultManager;
import domain.entity.Lotto;
import domain.PurchaseManager;
import view.InputManager;

import java.util.*;

public class LottoController {
    public void start() {
        PurchaseManager purchaseManager = new PurchaseManager();
        List<Lotto> purchasedLottoList = purchaseManager.purchase();

        List<Integer> winningNums = InputManager.inputWinningNums();

        ResultManager resultManager = new ResultManager(winningNums, purchasedLottoList);
        resultManager.getResult();
    }

}
