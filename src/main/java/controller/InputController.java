package controller;

import VO.PurchaseVO;
import VO.WinningLottoVO;
import service.PurchaseLottoInputService;
import service.WinningLottoInputService;

import java.util.List;

public class InputController {
    private final static PurchaseLottoInputService purchaseLottoInputService = new PurchaseLottoInputService();
    private final static WinningLottoInputService winningLottoInputService = new WinningLottoInputService();

    public PurchaseVO getPurchaseVO() {
        int money = purchaseLottoInputService.getMoney();
        int manualAmount = purchaseLottoInputService.getManualAmount();
        List<String> manualLottoStringList = purchaseLottoInputService.getManualLottoStringList(manualAmount);
        PurchaseVO purchaseVO = new PurchaseVO(money, manualAmount, manualLottoStringList);
        return purchaseVO;
    }

    public WinningLottoVO getWinningLottoVO() {
        String winningLottoString = winningLottoInputService.getWinningLottoString();
        int bonusNumber = winningLottoInputService.getBonusNumber();
        WinningLottoVO winningLottoVO = new WinningLottoVO(winningLottoString, bonusNumber);
        return winningLottoVO;
    }
}
