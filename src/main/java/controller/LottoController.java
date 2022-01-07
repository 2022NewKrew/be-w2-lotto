package controller;

import model.builder.UserLottoLineBuilder;
import model.calculate.EarningRatioCalculator;
import model.calculate.ResultCalculator;
import model.scan.BonusNumberScanner;
import model.scan.LottoNumberScanner;
import parameters.LottoResult;
import parameters.UserLottoLines;
import view.LottoEarningRatioViewer;
import view.UserLottoListViewer;
import view.UserResultViewer;

import java.util.List;

public class LottoController {
    private UserLottoLines userLottoLines;
    private List<Integer> winningNumbers;
    private int bonus;

    public LottoController() {
    }

    public void lottoFlow() {
        scanInput();
        renderView(calculateResult());
    }

    private void scanInput() {
        userLottoLines = UserLottoLineBuilder.makeUserLottoLines();
        UserLottoListViewer.view(userLottoLines);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        winningNumbers = LottoNumberScanner.getLottoNumbers();
        bonus = BonusNumberScanner.getBonusNumber(winningNumbers);
    }

    private LottoResult calculateResult() {
        return ResultCalculator.getLottoResult(userLottoLines, winningNumbers, bonus);
    }

    private void renderView(LottoResult lottoResult) {
        UserResultViewer.view(lottoResult);
        LottoEarningRatioViewer.view(
                EarningRatioCalculator.calculateEarningRatio(lottoResult, userLottoLines.getAmoutOfLotto())
        );
    }
}
