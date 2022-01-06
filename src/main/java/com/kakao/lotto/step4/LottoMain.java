package com.kakao.lotto.step4;

import com.kakao.lotto.step4.core.Lotto;
import com.kakao.lotto.step4.core.LottoResult;
import com.kakao.lotto.step4.view.InputLotto;
import com.kakao.lotto.step4.view.LottoPrinter;
import com.kakao.lotto.step4.view.LottoResultPrinter;

import java.util.List;

public class LottoMain {

    private int bonusNumber;
    private int lottoNumber;
    List<Lotto> lottos;
    List<Integer> winningNumbers;
    private InputLotto inputLotto = new InputLotto();
    LottoPrinter lottoPrinter = new LottoPrinter();

    public void inputPrice() {
        lottoNumber = inputLotto.getLottoNumber();
    }

    public void inputManualLottos() {
        lottos = inputLotto.getManualLottos(lottoNumber);
        lottoPrinter.printBuyLottoNumber(lottoNumber, lottos.size());
    }

    public void makeLotto() {
        lottos.addAll(Lotto.makeLottos(lottoNumber - lottos.size()));
        lottoPrinter.printLottos(lottos);
    }

    public void inputWinningNumbers() {
        winningNumbers = inputLotto.getWinningNumbers();
    }

    public void inputBonusNumber() {
        bonusNumber = inputLotto.getBonusNumber(winningNumbers);
    }

    public void printResult() {
        LottoResult lottoResult = new LottoResult(lottos, winningNumbers, bonusNumber);
        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter(lottoResult);
        lottoResultPrinter.printResults();
        lottoResultPrinter.printProfitRate();
    }

    public static void main(String[] args) {
        LottoMain lottoMain = new LottoMain();
        lottoMain.inputPrice();
        lottoMain.inputManualLottos();
        lottoMain.makeLotto();
        lottoMain.inputWinningNumbers();
        lottoMain.inputBonusNumber();
        lottoMain.printResult();
    }
}
