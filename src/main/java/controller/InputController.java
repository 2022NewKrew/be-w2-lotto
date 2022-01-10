package controller;

import VO.PurchaseVO;
import VO.WinningLottoVO;
import constant.LottoConstants;
import service.PurchaseLottoInputService;
import service.WinningLottoInputService;

import java.util.List;
import java.util.function.Function;

public class InputController {
    private final static PurchaseLottoInputService purchaseLottoInputService = new PurchaseLottoInputService();
    private final static WinningLottoInputService winningLottoInputService = new WinningLottoInputService();

    public PurchaseVO getPurchaseVO() {
        int money = getMoney();
        int manualAmount = getManualAmount(money);
        List<String> manualLottoStringList = getManualLottoStringList(manualAmount);
        PurchaseVO purchaseVO = new PurchaseVO(money, manualAmount, manualLottoStringList);
        return purchaseVO;
    }

    private int getMoney() throws IllegalArgumentException {
        int retry = 0;
        while (retry++ < LottoConstants.MAX_RETRIES) {
            try {
                return purchaseLottoInputService.getMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " (현재 시도 횟수: " + retry + "/"+ LottoConstants.MAX_RETRIES + "회)" );
            }
        }
        throw new IllegalArgumentException("Money 값 입력 최대 시도 횟수를 초과하였습니다.");
    }

    private int getManualAmount(int money) throws IllegalArgumentException {
        int retry = 0;
        while (retry++ < LottoConstants.MAX_RETRIES) {
            try {
                return purchaseLottoInputService.getManualAmount(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " (현재 시도 횟수: " + retry + "/"+ LottoConstants.MAX_RETRIES + "회)" );
            }
        }
        throw new IllegalArgumentException("ManualAmount 값 입력 최대 시도 횟수를 초과하였습니다.");
    }

    private List<String> getManualLottoStringList(int manualAmount) throws IllegalArgumentException {
        return purchaseLottoInputService.getManualLottoStringList(manualAmount);
    }



    public WinningLottoVO getWinningLottoVO() {
        String winningLottoString = winningLottoInputService.getWinningLottoString();
        int bonusNumber = winningLottoInputService.getBonusNumber();
        WinningLottoVO winningLottoVO = new WinningLottoVO(winningLottoString, bonusNumber);
        return winningLottoVO;
    }
}
