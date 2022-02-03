package controller;

import exception.LottoException;
import service.LottoInfoService;
import service.LottoPaperService;
import view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoView lottoView = new LottoView();
    private final LottoInfoService lottoInfoService = new LottoInfoService();
    private final LottoPaperService lottoPaperService = new LottoPaperService();

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

    public void inputLottoNumbers() {
        try {
            int amountManual = lottoInfoService.getAmountManual();

            List<String> lottoNumbers = new ArrayList<>();
            for (int buy = 0; buy < amountManual; buy++) {
                String input = lottoView.inputLottoNumbers();
                lottoNumbers.add(input);
            }
            lottoPaperService.setLottoNumbers(lottoNumbers);

        } catch (LottoException e) {
            lottoView.printMessage(e.getMessage());
            inputLottoNumbers();
        }
    }

    public void showLottoNumbers() {
        int manual = lottoInfoService.getAmountManual();
        int auto = lottoInfoService.getAmountAuto();
        String lottoNumbers = lottoPaperService.getLottoString();
        lottoView.printLotto(manual, auto, lottoNumbers);
    }

    // 지난 주 당첨 번호 입력

    // 보너스 번호 입력

    // 통계 가져오기

    public void run() {
        inputMoney();
        amountManualLotto();
        inputLottoNumbers();
        showLottoNumbers();
    }
}
