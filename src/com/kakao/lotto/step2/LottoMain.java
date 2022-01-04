package com.kakao.lotto.step2;

import com.kakao.lotto.step2.domain.Lotto;
import com.kakao.lotto.step2.domain.LottoResult;
import com.kakao.lotto.step2.view.InputLotto;
import com.kakao.lotto.step2.view.LottoPrinter;
import com.kakao.lotto.step2.view.LottoResultPrinter;

import java.util.List;
import java.util.stream.Stream;

public class LottoMain {

    private int lottoNumber;
    List<Lotto> lottos;
    List<Integer> winningNumbers;
    private InputLotto inputLotto = new InputLotto();
    LottoPrinter lottoPrinter = new LottoPrinter();

    public void inputPrice() {
        lottoNumber = inputLotto.getLottoNumber();
        lottoPrinter.printBuyLottoNumber(lottoNumber);
    }

    public void makeLotto() {
        lottos = Lotto.makeLottos(lottoNumber);
        lottoPrinter.printLottos(lottos);
    }

    public void inputWinningNumbers() {
        winningNumbers = inputLotto.getWinningNumbers();
    }

    public void printResult() {
        LottoResult lottoResult = new LottoResult(lottos, winningNumbers);
        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter(lottoResult);
        lottoResultPrinter.printResults();
        lottoResultPrinter.printProfitRate();
    }

    public static void main(String[] args) {
        LottoMain lottoMain = new LottoMain();
        lottoMain.inputPrice();
        lottoMain.makeLotto();
        lottoMain.inputWinningNumbers();
        lottoMain.printResult();
    }
}
