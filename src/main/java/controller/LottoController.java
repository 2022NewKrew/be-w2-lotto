package controller;

import model.builder.UserLottoLineBuilder;
import model.calculate.CalculateEarningRatio;
import model.calculate.CalculateResult;
import model.scan.BonusNumberScanner;
import model.scan.LottoNumberScanner;
import parameters.LottoResult;
import parameters.UserLottoLines;
import view.LottoEarningRatioViewer;
import view.UserLottoViewer;
import view.UserResultViewer;

import java.util.List;

public class LottoController {
    private UserLottoLines userLottoLines;
    private List<Integer> winningNumbers;
    private int bonus;

    public LottoController() { }

    public void lottoFlow(){
        scanInput();
        renderView(calulateResult());
    }

    private void scanInput(){
        userLottoLines = UserLottoLineBuilder.makeUserLottoLines();
        UserLottoViewer.viewUserLottoList(userLottoLines);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        winningNumbers = LottoNumberScanner.getLottoNumbers();
        bonus = BonusNumberScanner.getBonusNumber(winningNumbers);
    }

    private LottoResult calulateResult(){
        return CalculateResult.getLottoResult(userLottoLines, winningNumbers, bonus);
    }

    private void renderView(LottoResult lottoResult){
        UserResultViewer.viewResult(lottoResult);
        LottoEarningRatioViewer.viewEarningRatio(
                CalculateEarningRatio.calculateEarningRatio(lottoResult, userLottoLines.getAmoutOfLotto())
        );
    }
}
