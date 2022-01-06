package com.chanminkim.w2;

import com.chanminkim.w2.model.Lotto;
import com.chanminkim.w2.model.LottoNumber;
import com.chanminkim.w2.model.RandomLottoGenerator;
import com.chanminkim.w2.model.WinningStatistics;
import com.chanminkim.w2.view.InputView;
import com.chanminkim.w2.view.OutputView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        List<Lotto> boughtLottoList = buyLotto();
        Lotto winningLotto = INPUT_VIEW.getWinningLotto();
        LottoNumber bonus = new LottoNumber(INPUT_VIEW.getBonusNumber());
        WinningStatistics winningStatistics = new WinningStatistics(boughtLottoList, winningLotto, bonus);
        OUTPUT_VIEW.printWinningStatistics(winningStatistics);
    }

    private static List<Lotto> buyLotto() {
        int payment = INPUT_VIEW.getPayment();
        List<Lotto> manualLottoList = INPUT_VIEW.getManualLottoList(payment);
        int remainPayment = payment - manualLottoList.size() * Lotto.PRICE;
        List<Lotto> randomLottoList = buildRandomLottoList(remainPayment);
        App.OUTPUT_VIEW.printPurchasedLottoList(manualLottoList, randomLottoList);
        return Stream.of(manualLottoList, randomLottoList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
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
