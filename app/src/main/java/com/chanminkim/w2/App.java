package com.chanminkim.w2;

import com.chanminkim.w2.model.Lotto;
import com.chanminkim.w2.model.LottoNumber;
import com.chanminkim.w2.view.InputView;
import com.chanminkim.w2.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int payment = inputView.getPayment();
        List<Lotto> lottoList = buildRandomLottoList(payment);
        outputView.printPurchasedLottoList(lottoList);
        Lotto winningLotto = buildWinningLotto(inputView.getWinningLottoNumbers());
        outputView.printWinningStatistics(lottoList, winningLotto);
    }

    private static Lotto buildWinningLotto(List<Integer> winningLottoNumbers) {
        Lotto.Builder builder = new Lotto.Builder();
        winningLottoNumbers.stream()
                .map(LottoNumber::new)
                .forEach(builder::add);
        return builder.build();
    }

    private static List<Lotto> buildRandomLottoList(int payment) {
        int availableNumberOfLotto = payment / Lotto.LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < availableNumberOfLotto; i++) {
            lottoList.add(new Lotto.Builder().buildRandomly());
        }
        return lottoList;
    }
}
