package controller;

import exception.LottoException;
import service.LottoInfoService;
import service.LottoPaperService;
import service.LottoWinService;
import view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static LottoController lottoController = null;

    private final LottoView lottoView = new LottoView();
    private final LottoInfoService lottoInfoService = LottoInfoService.getLottoInfoService();
    private final LottoPaperService lottoPaperService = LottoPaperService.getLottoPaperService();
    private final LottoWinService lottoWinService = LottoWinService.getLottoWinService();

    private LottoController() {
    }

    public static LottoController getLottoController() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

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

    public void inputWinNumbers() {
        try {
            String input = lottoView.inputWinNumbers();
            lottoWinService.setWinNumbers(input);
        } catch (LottoException e) {
            lottoView.printMessage(e.getMessage());
            inputWinNumbers();
        }
    }

    public void inputBonusNumber() {
        try {
            String input = lottoView.inputBonusNumber();
            lottoWinService.setBonusNumber(input);
        } catch (LottoException e) {
            lottoView.printMessage(e.getMessage());
            inputBonusNumber();
        }
    }

    // 통계 가져오기

    public void run() {
        inputMoney();
        amountManualLotto();
        inputLottoNumbers();
        showLottoNumbers();
        inputWinNumbers();
        inputBonusNumber();
    }
}
