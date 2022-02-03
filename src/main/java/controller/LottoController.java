package controller;

import exception.LottoException;
import service.LottoInfoService;
import view.LottoView;

public class LottoController {

    private final LottoView lottoView = new LottoView();
    private final LottoInfoService lottoInfoService = new LottoInfoService();

    public void inputMoney() {
        try {
            String money = lottoView.inputMoney();
            lottoInfoService.setMoney(money);
        } catch (LottoException e) {
            lottoView.printMessage(e.getMessage());
            inputMoney();
        }
    }

    public void amountManualLotto() {
        try {
            String amountManual = lottoView.amountManualLotto();
            lottoInfoService.setAmountManual(amountManual);
        } catch (LottoException e) {
            lottoView.printMessage(e.getMessage());
            amountManualLotto();
        }
    }

    // 수동 구매할 번호 입력

    // 지난 주 당첨 번호 입력

    // 보너스 번호 입력

    // 통계 가져오기

    public void run() {
        inputMoney();
        amountManualLotto();
    }
}
