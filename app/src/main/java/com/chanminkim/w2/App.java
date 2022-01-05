package com.chanminkim.w2;

import com.chanminkim.w2.model.Lotto;
import com.chanminkim.w2.model.LottoNumber;
import com.chanminkim.w2.model.RandomLottoGenerator;
import com.chanminkim.w2.model.WinningStatistics;
import com.chanminkim.w2.view.InputView;
import com.chanminkim.w2.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int payment = inputView.getPayment();
        List<Lotto> manualLottoList = inputView.getManualLottoList(payment);
        int remainPayment = payment - manualLottoList.size() * Lotto.PRICE;
        List<Lotto> randomLottoList = buildRandomLottoList(remainPayment);
        outputView.printPurchasedLottoList(manualLottoList, randomLottoList);

        Lotto winningLotto = new Lotto(inputView.getWinningLottoNumbers());
        LottoNumber bonus = new LottoNumber(inputView.getBonusNumber());
        WinningStatistics winningStatistics = new WinningStatistics(randomLottoList, winningLotto, bonus);
        outputView.printWinningStatistics(winningStatistics);
    }

    private static List<Lotto> buildRandomLottoList(int payment) {
        int availableNumberOfLotto = payment / Lotto.PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < availableNumberOfLotto; i++) {
            lottoList.add(RandomLottoGenerator.generateLotto());
        }
        return lottoList;
    }
}
