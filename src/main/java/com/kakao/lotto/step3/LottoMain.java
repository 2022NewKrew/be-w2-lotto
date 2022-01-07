package com.kakao.lotto.step3;

import com.kakao.lotto.step3.core.Lotto;
import com.kakao.lotto.step3.core.LottoResult;
import com.kakao.lotto.step3.view.InputLotto;
import com.kakao.lotto.step3.view.LottoPrinter;
import com.kakao.lotto.step3.view.LottoResultPrinter;

import java.util.List;

public class LottoMain {

    private int bonusNumber;
    private int lottoCount;
    List<Lotto> lottos;
    List<Integer> winningNumbers;
    private InputLotto inputLotto = new InputLotto();
    LottoPrinter lottoPrinter = new LottoPrinter();

    public void getLottoCount() {
        lottoCount = inputLotto.getLottoCount();
    }

    public void inputManualLottos() {
        lottos = inputLotto.getManualLottos(lottoCount);
        lottoPrinter.printBuyLottoCount(lottoCount, lottos.size());
    }

    public void makeLotto() {
        lottos.addAll(Lotto.makeLottos(lottoCount - lottos.size()));
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
        lottoMain.getLottoCount();
        lottoMain.inputManualLottos();
        lottoMain.makeLotto();
        lottoMain.inputWinningNumbers();
        lottoMain.inputBonusNumber();
        lottoMain.printResult();

    }
}
