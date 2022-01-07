package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.*;

/**
 * 구매한 로또 리스트와
 * 로또 구매 / 당첨 번호 확인 메소드가 모여있는 클래스
 */
public class LottoGame {
    private final List<Lotto> lottoList = new ArrayList<>();  // 구매한 로또 리스트

    public final void start() {
        InputView.openScanner();

        LottoMachine lottoMachine = LottoMachine.getInstance();
        lottoMachine.buyAutoLotto(lottoList, InputView.inputPurchasePrice());
        lottoMachine.buyManualLotto(lottoList, InputView.inputManualLottoCount());
        OutputView.printLottoList(lottoList);

        LottoResult lottoResult = new LottoResult();
        lottoResult.checkAllLotto(lottoList);

        InputView.closeScanner();
    }
}
