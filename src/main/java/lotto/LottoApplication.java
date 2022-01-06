package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {

        // 구입금액 입력
        InputView.getPurchaseAmount();
        // 수동 구매 수 입력
        InputView.getManualPurchaseCount();
        // 로또 구매
        LottoController.buyLotto();
        // 구매 로또 출력
        OutputView.printLottos();
        // 당첨 번호 입력
        InputView.getWinningNumberList();
        // 보너스 볼 입력
        InputView.getBonusNumber();
        // 로또 당첨 확인
        LottoController.checkLotto();
        // 당첨 통계 출력
        OutputView.printLottoResults();
    }
}
