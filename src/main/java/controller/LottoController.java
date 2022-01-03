package controller;

import model.calculate.CalculateEarningRatio;
import model.calculate.CalculateResult;
import model.builder.AutoMaker;
import model.scan.AmountOfLottoScanner;
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
        int amountOfLotto = new AmountOfLottoScanner().getAmountOfLotto();
        UserLottoLines userLottoLines = new AutoMaker().makeLines(amountOfLotto);
        new UserLottoViewer().viewUserLottoList(userLottoLines);
        List<Integer> winningNumbers = new WinningNumberScanner().getWinningNumbers();
        LottoResult lottoResult = new CalculateResult().getLottoResult(userLottoLines, winningNumbers);
        new UserResultViewer().viewResult(lottoResult);
        new LottoEarningRatioViewer().viewEarningRatio(
                new CalculateEarningRatio().calculateEarningRatio(lottoResult, amountOfLotto)
        );
    }
}
