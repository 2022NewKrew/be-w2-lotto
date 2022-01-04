package com.kakao.lotto.step2;

import com.kakao.lotto.step2.domain.Lotto;
import com.kakao.lotto.step2.domain.LottoResult;
import com.kakao.lotto.step2.view.InputLotto;
import com.kakao.lotto.step2.view.LottoPrinter;
import com.kakao.lotto.step2.view.LottoResultPrinter;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int price = InputLotto.getPrice();
        InputLotto.printBuyLottoNumber(price / 1000);
        List<Lotto> lottos = Lotto.makeLottos(price / 1000);
        LottoPrinter lottoPrinter = new LottoPrinter(lottos);
        lottoPrinter.printLottos();
        List<Integer> winningNumbers = InputLotto.getWinningNumbers();
        LottoResult lottoResult = new LottoResult(price, lottos, winningNumbers);
        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter(lottoResult);
        lottoResultPrinter.printResults();
        lottoResultPrinter.printProfitRate();
    }
}
