package controller;

import constant.Message;
import dto.LottoResultDto;
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
            String money = lottoView.inputWithMessage(Message.HOW_MONEY);
            lottoInfoService.setMoney(money);
        } catch (LottoException e) {
            lottoView.printMessage(e.getMessage());
            inputMoney();
        }
    }

    public void amountManualLotto() {
        try {
            String amountManual = lottoView.inputWithMessage(Message.HOW_MANY_MANUAL);
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
                String input = lottoView.inputWithMessage(Message.ENTER_MANUAL_NUM);
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
            String input = lottoView.inputWithMessage(Message.LAST_WIN_NUM);
            lottoWinService.setWinNumbers(input);
        } catch (LottoException e) {
            lottoView.printMessage(e.getMessage());
            inputWinNumbers();
        }
    }

    public void inputBonusNumber() {
        try {
            String input = lottoView.inputWithMessage(Message.BONUS_NUM);
            lottoWinService.setBonusNumber(input);
        } catch (LottoException e) {
            lottoView.printMessage(e.getMessage());
            inputBonusNumber();
        }
    }

    public void showResult() {
        LottoResultDto result = lottoWinService.getLottoResult();
        lottoView.printMessage(result.toString());
    }

    public void run() {
        inputMoney();
        amountManualLotto();
        inputLottoNumbers();
        showLottoNumbers();
        inputWinNumbers();
        inputBonusNumber();
        showResult();
    }
}
