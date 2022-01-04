package controller;

import model.calculate.CalculateEarningRatio;
import model.calculate.CalculateResult;
import model.builder.LottoNumberGenerator;
import model.scan.AmountOfLottoScanner;
import model.scan.BonusNumberScanner;
import model.scan.WinningNumberScanner;
import parameters.LottoResult;
import parameters.UserLottoLines;
import view.LottoEarningRatioViewer;
import view.UserLottoViewer;
import view.UserResultViewer;

import java.util.List;

public class LottoController {
    public LottoController() { }

    public void lottoFlow(){
        int amountOfLotto = AmountOfLottoScanner.getAmountOfLotto();
        UserLottoLines userLottoLines = new LottoNumberGenerator().makeLines(amountOfLotto);
        UserLottoViewer.viewUserLottoList(userLottoLines);
        List<Integer> winningNumbers = WinningNumberScanner.getWinningNumbers();
        int bonus = BonusNumberScanner.getBonusNumber(winningNumbers);
        LottoResult lottoResult = CalculateResult.getLottoResult(userLottoLines, winningNumbers, bonus);
        UserResultViewer.viewResult(lottoResult);
        LottoEarningRatioViewer.viewEarningRatio(
                CalculateEarningRatio.calculateEarningRatio(lottoResult, amountOfLotto)
        );
    }
}
